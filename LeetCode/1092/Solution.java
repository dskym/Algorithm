class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;++i) {
            for(int j=1;j<=m;++j) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int a = n;
        int b = m;
        String result = "";
        while(a > 0 && b > 0) {
            if(str1.charAt(a-1) == str2.charAt(b-1)) {
                result = str1.charAt(a-1) + result;
                a--;
                b--;
            } else if(dp[a-1][b] > dp[a][b-1]) {
                result = str1.charAt(a-1) + result;
                a--;
            } else {
                result = str2.charAt(b-1) + result;
                b--;
            }
        }

        while(a > 0) {
            result = str1.charAt(a-1) + result;
            a--;
        }

        while(b > 0) {
            result = str2.charAt(b-1) + result;
            b--;
        }

        return result;
    }
}
