class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;

        long[][] dp = new long[n][m];

        for(int i=0;i<m;++i) {
            dp[0][i] = points[0][i];
        }

        for(int i=1;i<n;++i) {
            long[] left = new long[m];
            long[] right = new long[m];

            left[0] = dp[i-1][0];
            for(int j=1;j<m;++j) {
                left[j] = Math.max(left[j-1]-1, dp[i-1][j]);
            }

            right[m-1] = dp[i-1][m-1];
            for(int j=m-2;j>=0;--j) {
                right[j] = Math.max(right[j+1]-1, dp[i-1][j]);
            }

            for(int j=0;j<m;++j) {
                dp[i][j] = points[i][j] + Math.max(left[j], right[j]);
            }
        }

        long result = 0;
        for(int i=0;i<m;++i) {
            result = Math.max(result, dp[n-1][i]);
        }
        return result;
    }
}
