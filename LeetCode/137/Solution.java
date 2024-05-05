class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len/3;i++) {
            if(nums[i*3] == nums[i*3+1] && nums[i*3+1] == nums[i*3+2]) {
                continue;
            }
            if(nums[i*3] == nums[i*3+1]) {
                return nums[i*3+2];
            } else if(nums[i*3] == nums[i*3+2]) {
                return nums[i*3+1];
            } else {
                return nums[i*3];
            }
        }
        return nums[len-1];
    }
}
