class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int result = Math.abs(nums[0]-nums[nums.length-1]);
        for(int i=0;i<nums.length-1;++i) {
            result = Math.max(result, Math.abs(nums[i]-nums[i+1]));
        }
        return result;
    }
}
