class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int m = 0;
        for(int num : nums) {
            m = Math.max(num, m);
        }

        int start = 1;
        int end = m;

        int result = end;
        while(start < end) {
            int mid = (start + end) / 2;
            if(canDivide(nums, mid, maxOperations)) {
                end = mid;
                result = end;
            } else {
                start = mid+1;
            }
        }
        return result;
    }

    private boolean canDivide(int[] nums, int maxBalls, int maxOperations) {
        int result = 0;
        for(int num : nums) {
            result += (num + maxBalls - 1) / maxBalls - 1;
            if(result > maxOperations) {
                return false;
            }
        }
        return true;
    }
}
