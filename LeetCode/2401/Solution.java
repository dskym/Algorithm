class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;

        int temp = 0;
        int result = 1;
        while(end < n) {
            while((temp & nums[end]) != 0) {
                temp ^= nums[start];
                start++;
            }

            temp |= nums[end];
            result = Math.max(result, end-start+1);
            end++;
        }      
        return result;  
    }
}

