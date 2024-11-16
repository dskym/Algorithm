class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        for(int i=0;i<n-k+1;++i) {
            boolean flag = true;
            for(int j=0;j<k-1;++j) {
                if(nums[i+j]+1 != nums[i+j+1]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                result[i] = nums[i+k-1];
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}
