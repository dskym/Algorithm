class Solution {
    public int longestSubarray(int[] nums) {
        int m = 0;
        for(int i=0;i<nums.length;++i) {
            m = Math.max(m, nums[i]);
        }
        
        int count=0;
        int result=1;
        for(int i=0;i<nums.length;++i) {
            if(m == nums[i]) {
                count++;
            } else {
                result = Math.max(result, count);
                count=0;
            }
        }
        result = Math.max(result, count);

        return result;
    }
}
