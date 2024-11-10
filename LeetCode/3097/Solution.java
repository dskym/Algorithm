class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int start = 0;
        int end = 0;
        int result = 200001;

        int[] count = new int[32];

        while(end < n) {
            int[] temp = makeCount(nums[end]);
            for(int i=0;i<32;++i) {
                count[i] += temp[i];
            }
            while(check(k, count) && start <= end) {
                result = Math.min(result, end-start+1);
                int[] t = makeCount(nums[start]);
                for(int i=0;i<32;++i) {
                    count[i] -= t[i];
                }
                start++;
            }
            end++;
        }
        return (result == 200001) ? -1 : result;
    }

    private int[] makeCount(int v) {
        int[] result = new int[32];
        int index = 0;
        while(v != 0) {
            result[index++] = v % 2;
            v /= 2;
        }
        return result;
    }

    private boolean check(int k, int[] comp) {
        int result = 0;
        int base = 1;
        for(int i=0;i<32;++i) {
            if(comp[i] > 0) {
                result += base;
            }
            base *= 2;
        }
        return k <= result;
    }
}
