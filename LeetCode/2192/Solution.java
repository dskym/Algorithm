class Solution {
    List<List<Integer>> graph = new ArrayList();
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        for(int i=0;i<n;++i) {
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;++i) {
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        for(int i=0;i<n;++i) {
            solve(i, i, new boolean[n]);
        }
        
        return result;
    }

    public void solve(int parent, int node, boolean[] visited) {
        visited[node] = true;
        for(int i=0;i<graph.get(node).size();++i) {
            int next = graph.get(node).get(i);
            if(!visited[next]) {
                result.get(next).add(parent);
                solve(parent, next, visited);
            }
        }
    }
}
