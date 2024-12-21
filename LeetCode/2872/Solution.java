class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        boolean[] visited = new boolean[n];

        long[] v = new long[n];
        for(int i=0;i<values.length;++i) {
            v[i] = values[i];
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<edges.length;++i) {
            List<Integer> l1 = graph.getOrDefault(edges[i][0], new ArrayList<>());
            l1.add(edges[i][1]);
            graph.put(edges[i][0], l1);

            List<Integer> l2 = graph.getOrDefault(edges[i][1], new ArrayList<>());
            l2.add(edges[i][0]);
            graph.put(edges[i][1], l2);
        }

        return solve(0, -1, graph, visited, v, k);
    }

    private int solve(int node, int parent, Map<Integer, List<Integer>> graph, boolean[] visited, long[] values, int k) {
        if(visited[node]) {
            return 0;
        }
        
        List<Integer> nodeList = graph.get(node);
        if(nodeList == null) {
            return (values[node] % k == 0) ? 1 : 0;
        }

        visited[node] = true;

        int result = 0;
        for(int i=0;i<nodeList.size();++i) {
            result += solve(nodeList.get(i), node, graph, visited, values, k);
        }

        for(int i=0;i<nodeList.size();++i) {
            if(values[nodeList.get(i)] % k != 0 && nodeList.get(i) != parent) {
                values[node] += values[nodeList.get(i)];
            }
        }

        if(values[node] % k == 0) {
            result++;
        }

        return result;
    }
}
