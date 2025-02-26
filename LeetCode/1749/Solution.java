class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = 0;
        int max = 0;
        int temp = 0;

        for(int i=0;i<nums.length;++i) {
            temp += nums[i];
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        return max-min;
    }
}
