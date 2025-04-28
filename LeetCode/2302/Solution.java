class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        int start = 0;
        int end = 0;
        long total = 0;

        long result = 0;
        while(end < n) {
            total += nums[end];
            while(start <= end && (end-start+1) * total >= k) {
                total -= nums[start];
                start++;
            }
            result += end-start+1;
            end++;
        }
        return result;
    }
}
