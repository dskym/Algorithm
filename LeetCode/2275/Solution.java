class Solution {
    public int largestCombination(int[] candidates) {
        int result = 0;
        for(int i=0;i<25;++i) {
            int count = 0;
            for(int j=0;j<candidates.length;j++) {
                count += (candidates[j]%2);
                candidates[j] /= 2;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
