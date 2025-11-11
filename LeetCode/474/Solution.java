class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[][] count = new int[size][2];
        for(int i=0;i<size;++i) {
            String s = strs[i];
            int one = 0;
            int zero = 0;
            for(int j=0;j<s.length();++j) {
                if(s.charAt(j) == '0') {
                    zero++;
                } else {
                    one++;
                }
                count[i][0]= zero;
                count[i][1] = one;
            }
        }

        int[][][] dp = new int[size][m+1][n+1];
        for(int i=0;i<size;++i) {
            for(int j=0;j<=m;++j) {
                for(int k=0;k<=n;++k) {
                    dp[i][j][k] = -1;
                }
            }
        }

        int result = 0;
        for(int i=0;i<size;++i) {
            result = Math.max(result, solve(dp, count, i, size, m, n));
        }
        return result;
    }

    private int solve(int[][][] dp, int[][] count, int index, int size, int m, int n) {
        if(index >= size) {
            return 0;
        }

        if(dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        dp[index][m][n] = solve(dp, count, index+1, size, m, n);
        if(m-count[index][0] >= 0 && n-count[index][1] >= 0) {
            dp[index][m][n] = Math.max(dp[index][m][n], 1 + solve(dp, count, index+1, size, m-count[index][0], n-count[index][1]));
        }
        return dp[index][m][n];
    }
}
