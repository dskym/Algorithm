class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        int a = nums1.length;
        int b = nums2.length;
        if(a % 2 == 1 && b % 2 == 1) {
            for(int num : nums1) {
                result ^= num;
            }
            for(int num : nums2) {
                result ^= num;
            }
        } else if(a % 2 == 1) {
            for(int num : nums2) {
                rexsult ^= num;
            }
        } else if(b % 2 == 1) {
            for(int num : nums1) {
                result ^= num;
            }
        }
        return result;
    }
}
