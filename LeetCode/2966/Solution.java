class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int[][] result = new int[n/3][3];
        for(int i=0;i<n/3;++i) {
            for(int j=0;j<3;++j) {
                result[i][j] = nums[i*3+j];
            }
        }

        for(int i=0;i<n/3;++i) {
            if(result[i][1]-result[i][0] > k || result[i][2]-result[i][0] > k) {
                return new int[][]{};
            }
        }

        return result;
    }
}
