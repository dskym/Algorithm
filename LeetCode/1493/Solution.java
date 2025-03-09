class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int result = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        while(end < n) {
            if(nums[end] == 0) {
                count++;
            }

            if(count == 2) {
                count--;
                while(nums[start] == 1) {
                    start++;
                }
                if(nums[start] == 0) {
                     start++;
                }
            }
            result = Math.max(end-start+1-count, result);
            end++;
        }
        if(count == 0) {
            result--;
        }
        return result;
    }
}
