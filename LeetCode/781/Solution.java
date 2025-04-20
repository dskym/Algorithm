class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1001];
        for(int answer : answers) {
            count[answer]++;
        }

        int result = 0;
        for(int i=0;i<=1000;++i) {
            int remain = count[i] % (i+1);
            result += count[i] / (i+1) * (i+1);
            if(remain > 0) {
                result += (i+1);
            }
        }
        return result;
    }
}
