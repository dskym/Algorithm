class Solution {
    int result = 0;

    public int countMaxOrSubsets(int[] nums) {
        int maxNum = 0;
        for(int num : nums) {
            maxNum |= num;
        }

        solve(nums, 0, maxNum, 0);

        return result;
    }

    private void solve(int[] nums, int index, int target, int temp) {
        if(nums.length <= index) {
            return;
        }

        int next = temp | nums[index];

        solve(nums, index+1, target, temp);
        solve(nums, index+1, target, next);

        if(target == next) {
            result++;
        }
    }
}
