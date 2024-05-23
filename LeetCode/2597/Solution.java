class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] counter = new int[2001];
        return solve(nums, k, 0, counter)-1;
    }

    public int solve(int[] nums, int k, int start, int[] counter) {
        if(nums.length == start) {
            return 1;
        }

        int result = 0;
        result += solve(nums, k, start+1, counter);
        if((nums[start]-k >= 0 && counter[nums[start]-k] > 0) || counter[nums[start]+k] > 0) {
            return result;
        }
        counter[nums[start]]++;
        result += solve(nums, k, start+1, counter);
        counter[nums[start]]--;
        return result;
    }
}
