class Solution {
    int[][] dp = new int[1001][1001];
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                dp[i][j] = -1;
            }
        }

        int result = 0;
        for(int i=0;i<n;++i) {
            result = Math.max(result, solve(grid, i, 0, n, m));
        }
        return result;
    }

    private int solve(int[][] grid, int x, int y, int n, int m) {
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        int result = 0;
        if(x > 0 && y < m-1 && grid[x][y] < grid[x-1][y+1]) {
            result = Math.max(result, solve(grid, x-1, y+1, n, m)+1);
        }
        if(y < m-1 && grid[x][y] < grid[x][y+1]) {
            result = Math.max(result, solve(grid, x, y+1, n, m)+1);
        }
        if(x < n-1 && y < m-1 && grid[x][y] < grid[x+1][y+1]) {
            result = Math.max(result, solve(grid, x+1, y+1, n, m)+1);
        }
        dp[x][y] = result;
        return result;
    }
}
