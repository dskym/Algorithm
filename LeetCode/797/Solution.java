class Solution {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public void dfs(int[][] graph, int s, int d, List<Integer> path) 
    {
        if(s == d) {            
            result.add(new ArrayList(path));
            
            return;
        }
        
        for(int i=0;i<graph[s].length;++i) {
            path.add(new Integer(graph[s][i]));
            dfs(graph, graph[s][i], d, path);
            path.remove(new Integer(graph[s][i]));
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {        
        List<Integer> path = new ArrayList<Integer>();

        path.add(0);
        dfs(graph, 0, graph.length - 1, path);
        
        return result;
    }
}
