class Solution {
    public int minOperations(int[] nums) {
        int result = 0;
        int n = nums.length;
        for(int i=0;i<n-2;++i) {
            if(nums[i] == 0) {
                for(int j=0;j<3;++j) {
                    nums[i+j] = (nums[i+j] == 1) ? 0 : 1;
                }
                result++;
            }
        }

        for(int num : nums) {
            if(num == 0) {
                return -1;
            }
        }
        return result;
    }
}
