class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int baseIndex = 0;
        int minIndex = -1;
        int maxIndex = -1;

        long result = 0;
        for(int i=0;i<n;++i) {
            if(nums[i] < minK || nums[i] > maxK) {
                baseIndex = i+1;
                continue;
            }

            if(maxK == nums[i]) {
                maxIndex = i;
            }
            if(minK == nums[i]) {
                minIndex = i;
            }

            result += Math.max(Math.min(maxIndex, minIndex)-baseIndex+1, 0);
        }
        return result;
    }
}
