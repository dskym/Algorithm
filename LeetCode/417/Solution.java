class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                boolean[][] visited = new boolean[n][m];
                boolean pacific = false;
                boolean atlantic = false;

                dfs(heights, visited, i, j, n, m);

                for(int k=0;k<n;++k) {
                    if(visited[k][0]) {
                        pacific = true;
                    }
                    if(visited[k][m-1]) {
                        atlantic = true;
                    }
                }
                for(int k=0;k<m;++k) {
                    if(visited[0][k]) {
                        pacific = true;
                    }
                    if(visited[n-1][k]) {
                        atlantic = true;
                    }
                }
                if(pacific && atlantic) {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int x, int y, int n, int m) {
        int[][] direct = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        visited[x][y] = true;
        for(int i=0;i<4;++i) {
            int dx = x+direct[i][0];
            int dy = y+direct[i][1];
            if(dx >= 0 && dx < n && dy >= 0 && dy < m && visited[dx][dy] == false && heights[dx][dy] <= heights[x][y]) {
                dfs(heights, visited, dx, dy, n, m);
            }
        }
    }
}
