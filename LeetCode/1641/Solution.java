class Solution {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n][5];
        for(int i=0;i<5;++i) {
            dp[0][i] = 1;
        }

        for(int i=1;i<n;++i) {
            for(int j=0;j<5;++j) {
                int temp = 0;
                for(int k=j;k<5;++k) {
                    temp += dp[i-1][k];
                }
                dp[i][j] = temp;
            }
        }

        int result = 0;
        for(int i=0;i<5;++i) {
            result += dp[n-1][i];
        }
        return result;
    }
}
