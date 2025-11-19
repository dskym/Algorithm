class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        int index = -1000000000;
        for(int i=0;i<n;++i) {
            if(nums[i] == 1) {
                if(k >= i-index) {
                    return false;
                }
                index = i;
            }
        }
        return true;
    }
}
