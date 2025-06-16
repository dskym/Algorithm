class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int result = -1;
        for(int i=0;i<n;++i) {
            for(int j=i+1;j<n;++j) {
                if(nums[i] < nums[j]) {
                    result = Math.max(result, nums[j]-nums[i]);
                }
            }
        }
        return Math.max(-1, result);
    }
}
