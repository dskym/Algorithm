class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n];

        presum[0] = nums[0];
        for(int i=1;i<n;++i) {
            presum[i] = presum[i-1]+nums[i];
        }

        int result = 0;
        for(int i=0;i<n-1;++i) {
            int diff = presum[n-1]-2*presum[i];
            if(diff % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}
