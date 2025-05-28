class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, List<Integer>> g1 = build(edges1);
        Map<Integer, List<Integer>> g2 = build(edges2);

        int n = edges1.length+1;
        int m = edges2.length+2;

        int max = 0;
        for(int i=0;i<m;++i) {
            boolean[] visited = new boolean[m];
            visited[i] = true;
            max = Math.max(max, dfs(g2, i, k-1, visited));
        }

        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            result[i] = dfs(g1, i, k, visited)+max;
        }
        return result;
    }

    private Map<Integer, List<Integer>> build(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();        
        for(int[] edge : edges) {
            List<Integer> l1 = g.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            g.put(edge[0], l1);
            List<Integer> l2 = g.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            g.put(edge[1], l2);
        }
        return g;
    }

    private int dfs(Map<Integer, List<Integer>> g, int node, int k, boolean[] visited) {
        if(k < 0) {
            return 0;
        }

        int result = 1;
        List<Integer> l = g.getOrDefault(node, new ArrayList<>());
        for(int i=0;i<l.size();++i) {
            if(visited[l.get(i)] == false) {
                visited[l.get(i)] = true;
                result += dfs(g, l.get(i), k-1, visited);
            }
        }
        return result;
    }
}
