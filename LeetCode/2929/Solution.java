class Solution {
    public long distributeCandies(int n, int limit) {
        long result = 0;
        for(int i=0;i<=Math.min(n, limit);++i) {
            if(n-i > limit*2) {
                continue;
            }
            result += Math.min(n-i, limit) - Math.max(0, n-i-limit)+1;
        }
        return result;
    }
}
