class Solution {
    public int numTilings(int n) {
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4;i<=n;++i) {
            dp[i] = (2 * dp[i-1] % 1000000007 + dp[i-3] % 1000000007) % 1000000007;
        }
        return dp[n];
    }
}
