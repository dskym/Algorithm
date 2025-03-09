class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int i=0;i<m;++i) {
            dp[0][i] = grid[0][i];
        }

        for(int i=1;i<n;++i) {
            for(int j=0;j<m;++j) {
                int temp = Integer.MAX_VALUE;
                for(int k=0;k<m;++k) {
                    temp = Math.min(temp, dp[i-1][k] + moveCost[grid[i-1][k]][j]);
                }
                dp[i][j] = temp+grid[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0;i<m;++i) {
            result = Math.min(result, dp[n-1][i]);
        }
        return result;
    }
}
