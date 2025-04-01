class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[][] dp = new long[n+1][2];
        for(int i=n-1;i>=0;--i) {
            long temp = questions[i][0];
            int index = i+questions[i][1]+1;
            if(index < n) {
                temp += Math.max(dp[index][0], dp[index][1]);
            }
            dp[i][1] = Math.max(dp[i+1][0], dp[i+1][1]);
            dp[i][0] = Math.max(temp, dp[i][1]);
        }
        return Math.max(dp[0][0], dp[0][1]);
    }
}
