class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();

        Map<String, List<Pair<String, Double>>> graph = new HashMap<>();
        Map<Pair<String, String>, Double> probMap = new HashMap<>();
        for(int i=0;i<n;++i) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            List<Pair<String, Double>> nodeList1 = graph.getOrDefault(u, new ArrayList<>());
            nodeList1.add(new Pair(v, values[i]));
            graph.put(u, nodeList1);

            List<Pair<String, Double>> nodeList2 = graph.getOrDefault(v, new ArrayList<>());
            nodeList2.add(new Pair(u, 1 / values[i]));
            graph.put(v, nodeList2);
        }

        int m = queries.size();
        for(int i=0;i<m;++i) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if(probMap.containsKey(new Pair(start, end))) {
                continue;
            }

            PriorityQueue<Pair<String, Double>> pq = new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
            pq.add(new Pair(start, 1.0));

            while(!pq.isEmpty()) {
                Pair<String, Double> pair = pq.poll();
                String node = pair.getKey();
                Double prob = pair.getValue();

                if(graph.containsKey(node)) {
                    for(int j=0;j<graph.get(node).size();++j) {
                        String target = graph.get(node).get(j).getKey();
                        Double targetProb = graph.get(node).get(j).getValue();

                        if(!probMap.containsKey(new Pair(start, target))) {
                            probMap.put(new Pair(start, target), targetProb*prob);
                            pq.add(new Pair(target, targetProb*prob));
                        }
                    }
                }
            }
        }

        double[] result = new double[m];
        for(int i=0;i<m;++i) {
            result[i] = probMap.getOrDefault(new Pair(queries.get(i).get(0), queries.get(i).get(1)), -1.0);
        }
        return result;
    }
}
