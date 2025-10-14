class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for(int i=0;i<n-2*k+1;++i) {
            boolean flag = true;
            for(int j=0;j<k-1;++j) {
                if(nums.get(i+j) >= nums.get(i+j+1) || nums.get(i+k+j) >= nums.get(i+j+k+1)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return true;
            }
        }
        return false;
    }
}
