class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] check = new int[n];
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;++i) {
            visited[i] = true;
            if(solve(graph, i, visited, check)) {
                result.add(i);
            }
            visited[i] = false;
        }

        return result;
    }

    private boolean solve(int[][] graph, int node, boolean[] visited, int[] check) {
        if(check[node] == 2) {
            return true;
        } else if(check[node] == 1) {
            return false;
        }

        if(graph[node].length == 0) {
            check[node] = 2;
            return true;
        }

        for(int i=0;i<graph[node].length;++i) {
            if(visited[graph[node][i]]) {
                return false;
            }


            visited[graph[node][i]] = true;
            if(solve(graph, graph[node][i], visited, check) == false) {
                check[node] = 1;
                return false;
            }
            visited[graph[node][i]] = false;
        }

        check[node] = 2;
        return true;
    }
}
