class Solution {
    public int findKthNumber(int n, int k) {
        int result = 1;
        k--;
        while(k > 0) {
            int c = count(result, n);
            if(k >= c) {
                k -= c;
                result++;
            } else {
                result *= 10;
                k--;
            }
        }
        return result;
    }

    private int count(int prefix, int n) {
        long curr = prefix;
        long next = prefix+1;

        int total = 0;
        while(curr <= n) {
            total += Math.min(n+1, next)-curr;
            curr *= 10;
            next *= 10;
        }
        return total;
    }
}
