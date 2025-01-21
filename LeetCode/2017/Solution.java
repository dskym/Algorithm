class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        if(n == 1) {
            return 0;
        }

        long[][] dp = new long[2][n];
        dp[0][n-1] = grid[0][n-1];
        dp[1][0] = grid[1][0];

        for(int i=n-2;i>0;--i) {
            dp[0][i] = grid[0][i]+dp[0][i+1];
        }
        for(int i=1;i<n-1;++i) {
            dp[1][i] = grid[1][i]+dp[1][i-1];
        }

        long temp = Long.MAX_VALUE;
        int index = -1;
        for(int i=0;i<n;++i) {
            if(i == 0) {
                if(temp > dp[0][i+1]) {
                    temp = dp[0][i+1];
                    index = i;
                }
            } else if(i == n-1) {
                if(temp > dp[1][i-1]) {
                    temp = dp[1][i-1];
                    index = i;
                }
            } else {
                if(temp > Math.max(dp[1][i-1], dp[0][i+1])) {
                    temp = Math.max(dp[1][i-1], dp[0][i+1]);
                    index = i;
                }
            }
        }

        return temp;
    }
}
