class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        int start = 0;
        int end = 0;
        int[] count = new int[1000001];
        long result = 0;
        while(end < n) {
            count[nums[end]]++;
            while(count[max] >= k) {
                count[nums[start]]--;
                result += n-end;
                start++;
            }
            end++;
        }
        return result;
    }
}
