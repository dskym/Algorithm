class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][] dp = new int[41][41];
        int n = arr.length;

        return solve(arr, 0, n-1, dp);
    }

    private int solve(int[] arr, int i, int j, int[][] dp) {
        if(i == j) {
            return 0;
        }

        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        int result = Integer.MAX_VALUE;
        for(int k=i;k<j;++k) {
            int left = 0;
            for(int a=i;a<=k;++a) {
                left = Math.max(left, arr[a]);
            }

            int right = 0;
            for(int a=k+1;a<=j;++a) {
                right = Math.max(right, arr[a]);
            }

            int temp = left*right + solve(arr, i, k, dp) + solve(arr, k+1, j, dp);
            result = Math.min(result, temp);
        }
        dp[i][j] = result;
        return result;
    }
}
