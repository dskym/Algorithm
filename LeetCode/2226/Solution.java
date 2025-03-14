class Solution {
    public int maximumCandies(int[] candies, long k) {
        int start = 1;
        int end = 10000000;

        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;

            if(solve(candies, mid, k)) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return result;
    }

    private boolean solve(int[] candies, int count, long k) {
        long c = 0;
        for(int candy : candies) {
            c += candy / count;
        }
        return c >= k;
    }
}
