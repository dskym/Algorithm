class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;

        int[] xor = new int[n];
        xor[0] = nums[0];
        for(int i=1;i<n;++i) {
            xor[i] = nums[i] ^ xor[i-1];
        }

        int base = (1 << maximumBit) - 1;

        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            int temp = xor[n-i-1] | base;
            result[i] = temp ^ xor[n-i-1];
        }
        return result;
    }
}
