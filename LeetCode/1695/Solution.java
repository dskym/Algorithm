class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        int[] count = new int[100001];
        int result = 0;
        int temp = 0;
        while(end < n) {
            temp += nums[end];
            count[nums[end]]++;
            while(count[nums[end]] > 1) {
                temp -= nums[start];
                count[nums[start]]--;
                start++;
            }
            result = Math.max(result, temp);
            end++;
        }
        return result;
    }
}
