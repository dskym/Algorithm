class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int start = 0;
        int end = n-1;
        int result = Integer.MAX_VALUE;
        for(int i=0;i<4;++i) {
            result = Math.min(result, nums[end-i]-nums[start+3-i]);
        }
        return result;
    }
}
