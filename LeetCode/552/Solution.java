class Solution {
    public int checkRecord(int n) {
        long[][][] dp = new long[100001][2][3];
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;
        dp[1][1][1] = 0;
        dp[1][0][2] = 0;
        dp[1][1][2] = 0;

        for(int i=2;i<=n;++i) {
            dp[i][0][0] = (dp[i-1][0][0]+dp[i-1][0][1]+dp[i-1][0][2]) % 1000000007;
            dp[i][0][1] = dp[i-1][0][0];
            dp[i][0][2] = dp[i-1][0][1];
            dp[i][1][0] = (dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2] + dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % 1000000007;
            dp[i][1][1] = dp[i-1][1][0];
            dp[i][1][2] = dp[i-1][1][1];
        }

        long result = 0;
        for(int i=0;i<2;++i) {
            for(int j=0;j<3;++j) {
                result = (result + dp[n][i][j]) % 1000000007;
            }
        }
        return (int)result;     
    }
}
