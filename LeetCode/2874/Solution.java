class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int temp = 0;
        for(int i=0;i<n;++i) {
            temp = Math.max(nums[i], temp);
            prefix[i] = temp;
        }

        temp = 0;
        for(int i=n-1;i>=0;--i) {
            temp = Math.max(nums[i], temp);
            suffix[i] = temp;
        }

        long result = 0;
        for(int i=1;i<n-1;++i) {
            long t = (long)(prefix[i-1]-nums[i])*suffix[i+1];
            result = Math.max(result, t);
        }
        return Math.max(result, 0);
    }
}
