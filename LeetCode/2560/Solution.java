class Solution {
    public int minCapability(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for(int num : nums) {
            end = Math.max(end, num);
        }

        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;

            if(solve(nums, mid, k)) {
                result = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return result;
    }

    private boolean solve(int[] nums, int test, int k) {
        int result = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i] <= test) {
                result++;
                i++;
            }
        }
        return result >= k;
    }
}
