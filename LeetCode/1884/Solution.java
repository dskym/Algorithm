class Solution {
    public int twoEggDrop(int n) {
        int[] dp = new int[101];
        dp[1] = 1;
        for(int i=2;i<=100;++i) {
            dp[i] = i+dp[i-1];
        }
        
        for(int i=1;i<=100;++i) {
            if(dp[i] >= n) {
                return i;
            }
        }

        return 0;
    }
}
