class Solution {
    public int smallestNumber(int n) {
        int[] dp = new int[12];
        dp[0] = 1;
        for(int i=1;i<12;++i) {
            dp[i] = dp[i-1]*2;
        }

        for(int i=0;i<12;++i) {
            if(n <= dp[i]-1) {
                return dp[i]-1;
            }
        }
        return -1;
    }
}
