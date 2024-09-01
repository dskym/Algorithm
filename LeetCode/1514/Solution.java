class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] result = new double[n];
        result[start_node] = 1.0;

        // make graph
        List<List<Pair<Integer, Double>>> graph = new ArrayList<>();
        for(int i=0;i<n;++i) {
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;++i) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        // Shortest Path
        PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<Pair<Integer, Double>>((a, b) -> b.getValue().compareTo(a.getValue()));
        pq.add(new Pair(start_node, 1.0));

        while(!pq.isEmpty()) {
            Pair<Integer, Double> p = pq.poll();
            Integer u = p.getKey();
            Double currProb = p.getValue();

            for(int i=0;i<graph.get(u).size();++i) {
                Integer v = graph.get(u).get(i).getKey();
                Double edgeProb = graph.get(u).get(i).getValue();

                if(currProb * edgeProb > result[v]) {
                    result[v] = currProb * edgeProb;
                    pq.add(new Pair(v, result[v]));
                }
            }
        }

        return result[end_node];
    }
}
