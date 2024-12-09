class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] preSum = new int[n];

        for(int i=1;i<n;++i) {
            preSum[i] = preSum[i-1];
            if((nums[i-1] % 2 == 0 && nums[i] % 2 == 0)
            || (nums[i-1] % 2 != 0 && nums[i] % 2 != 0)) {
                preSum[i]++;
            }
        }

        int m = queries.length;
        boolean[] result = new boolean[m];
        for(int i=0;i<m;++i) {
            if(queries[i][0] == 0) {
                result[i] = preSum[queries[i][1]] == 0;
            } else {
                result[i] = preSum[queries[i][1]] == preSum[queries[i][0]];
            }
        }
        return result;
    }
}
