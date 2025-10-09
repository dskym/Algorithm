class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] dp = new long[n];

        dp[0] = skill[0] * mana[0];
        for(int i=1;i<n;++i) {
            dp[i] = dp[i-1] + (long)skill[i] * mana[0];
        }

        for(int j=1;j<m;++j) {
            dp[0] = dp[0] + (long)skill[0] * mana[j];
            for(int i=1;i<n;++i) {
                dp[i] = (long)skill[i] * mana[j] + Math.max(dp[i-1], dp[i]);
            }
            for(int i=n-2;i>=0;--i) {
                dp[i] = dp[i+1] - (long)skill[i+1] * mana[j];
            }
        }

        return dp[n-1];
    }
}
