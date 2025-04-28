class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int result = 0;
        int count = k;
        while(end < n) {
            if(nums[end] == 0) {
                count--;
            }
            while(count < 0) {
                if(nums[start] == 0) {
                    count++;
                }
                start++;
            }
            result = Math.max(result, end-start+1);
            end++;
        }
        return result;
    }
}
