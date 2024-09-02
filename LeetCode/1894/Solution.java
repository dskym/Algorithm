class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;

        long[] prefixSum = new long[n];
        long sum = 0;

        for(int i=0;i<n;++i) {
            sum += chalk[i];
            prefixSum[i] = sum;
        }

        long temp = k % sum;
        for(int i=0;i<n;++i) {
            if(prefixSum[i] > temp) {
                return i;
            }
        }
        return n-1;
    }
}
