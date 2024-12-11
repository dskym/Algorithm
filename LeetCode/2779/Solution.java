class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;

        int result = 1;
        for(int i=0;i<n;++i) {
            int start = 0;
            int end = n-1;
            while(start <= end) {
                int mid = (start+end)/2;
                if(nums[mid] <= nums[i]+2*k) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            result = Math.max(result, end-i+1);
        }
        return result;
    }
}
