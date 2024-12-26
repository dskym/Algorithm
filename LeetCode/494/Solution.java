class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, target, 0, 0);
    }

    private int solve(int[] nums, int target, int index, int sum) {
        if(nums.length == index) {
            return (sum == target) ? 1 : 0;
        }

        int result = 0;
        result += solve(nums, target, index+1, sum+nums[index]);
        result += solve(nums, target, index+1, sum-nums[index]);
        return result;
    }
}
