class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n-1;++i) {
            List<Integer> l = new ArrayList<>();
            l.add(i+1);
            graph.put(i, l);
        }

        int[] result = new int[queries.length];
        int index = 0;
        for(int[] query : queries) {
            boolean[] visited = new boolean[n];
            List<Integer> l = graph.getOrDefault(query[0], new ArrayList());
            l.add(query[1]);
            graph.put(query[0], l);

            Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
            queue.add(new Pair(0, 0));
            visited[0] = true;
            while(!queue.isEmpty()) {
                Pair<Integer, Integer> p = queue.poll();
                int node = p.getKey();
                int count = p.getValue();

                if(node == n-1) {
                    result[index++] = count;
                    break;
                }

                List<Integer> nodeList = graph.get(node);
                for(int i=0;i<nodeList.size();++i) {
                    if(visited[nodeList.get(i)] == false) {
                        queue.add(new Pair(nodeList.get(i), count+1));
                        visited[nodeList.get(i)] = true;
                    }
                }
            }
        }
        return result;
    }
}
