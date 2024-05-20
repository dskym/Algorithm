class Solution {
    public int subsetXORSum(int[] nums) {
        return solve(nums, 0, 0);   
    }

    public int solve(int[] nums, int index, int sum) {
        if(nums.length == index) {
            return sum;
        }

        int result = 0;
        result += solve(nums, index+1, sum ^ nums[index]);
        result += solve(nums, index+1, sum);
        return result;
    }
}
