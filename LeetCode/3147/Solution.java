class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n+k];
        for(int i=n-1;i>=0;--i) {
            dp[i] = dp[i+k] + energy[i];
        }

        int result = Integer.MIN_VALUE;
        for(int i=0;i<n;++i) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
