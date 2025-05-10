class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long left = 0;
        int leftCount = 0;
        for(int num : nums1) {
            if(num == 0) {
                leftCount++;
            }
            left += num;
        }

        long right = 0;
        int rightCount = 0;
        for(int num : nums2) {
            if(num == 0) {
                rightCount++;
            }
            right += num;
        }

        if(leftCount > 0 && rightCount > 0) {
            return Math.max(left+leftCount, right+rightCount);
        } else if(leftCount > 0) {
            if(leftCount <= right-left) {
                return right;
            } else {
                return -1;
            }
        } else if(rightCount > 0) {
            if(rightCount <= left-right) {
                return left;
            } else {
                return -1;
            }
        } else {
            if(left == right) {
                return left;
            } else {
                return -1;
            }
        }
    }
}
