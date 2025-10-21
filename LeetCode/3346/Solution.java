class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int[] counter = new int[200005];
        for(int num : nums) {
            counter[num]++;
        }

        int count = 0;
        for(int i=1;i<=k;++i) {
            count += counter[i];
        }

        int result = Math.min(count, numOperations);
        for(int i=1;i<=100000;++i) {
            count += counter[i+k];
            if(i-k-1>=0) {
                count -= counter[i-k-1];
            }
            result = Math.max(result, Math.min(numOperations+counter[i], count));
        }
        return result;
    }
}
