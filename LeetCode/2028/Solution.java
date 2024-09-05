class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n+m);

        int partialSum = 0;
        for(int i=0;i<m;++i) {
            partialSum += rolls[i];
        }

        int remainSum = total - partialSum;
        if(remainSum < n || remainSum > n*6) {
            return new int[0];
        }

        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            result[i] = remainSum / n;
        }
        remainSum = remainSum % n;

        for(int i=0;i<n;++i) {
            if(remainSum-- > 0) {
                result[i]++;
            }
        }
        return result;
    }
}
