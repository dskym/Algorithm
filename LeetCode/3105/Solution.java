class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int result = 0;

        int count = 1;
        for(int i=0;i<n-1;++i) {
            if(nums[i] < nums[i+1]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);

        count = 1;
        for(int i=0;i<n-1;++i) {
            if(nums[i] > nums[i+1]) {
                count++;
            } else {
                result = Math.max(result, count);
                count = 1;
            }
        }
        result = Math.max(result, count);

        return result;
    }
}
