class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[100001];
        dp[zero] += 1;
        dp[one] += 1;
        for(int i=1;i<=high;++i) {
            if(i-zero>=0) {
                dp[i] = (dp[i] + dp[i-zero]) % 1000000007;
            }
            if(i-one>=0) {
                dp[i] = (dp[i] + dp[i-one]) % 1000000007;
            }
        }

        int result = 0;
        for(int i=low;i<=high;++i) {
            result = (result + dp[i]) % 1000000007;
        }
        return result;
    }
}


