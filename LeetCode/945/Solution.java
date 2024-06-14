class Solution {
    public int minIncrementForUnique(int[] nums) {
        int result = 0;

        Arrays.sort(nums);
        int maxCount = nums[0];

        for(int i=1;i<nums.length;++i) {
            if(nums[i] < maxCount+1) {
                result += maxCount-nums[i]+1;
                maxCount++;
            } else if(nums[i] > maxCount) {
                maxCount = nums[i];
            }
        }

        return result;
    }
}

