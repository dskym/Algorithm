class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> l1 = graph.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            graph.put(edge[0], l1);

            List<Integer> l2 = graph.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            graph.put(edge[1], l2);
        }

        Set<Integer> set = new HashSet<>();
        for(int r : restricted) {
            set.add(r);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        
        int result = 0;
        while(!q.isEmpty()) {
            int node = q.poll();

            if(set.contains(node)) {
                continue;
            }

            if(graph.get(node) != null) {
                for(int i=0;i<graph.get(node).size();++i) {
                    int next = graph.get(node).get(i);

                    if(visited[next] == false) {
                        q.add(next);
                        visited[next] = true;
                    }
                }
            }

            result++;
        }
        return result;
    }
}
