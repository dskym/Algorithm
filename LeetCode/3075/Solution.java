class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long result = 0;
        for(int i=0;i<k;++i) {
            result += Math.max(happiness[happiness.length-i-1]-i, 0);
        }
        return result;
    }
}
