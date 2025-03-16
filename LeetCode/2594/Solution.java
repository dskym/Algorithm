class Solution {
    public long repairCars(int[] ranks, int cars) {
        long start = 1;
        long end = Long.MAX_VALUE;

        long result = 0;
        while(start < end) {
            long mid = (start+end)/2;
            if(solve(ranks, cars, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private boolean solve(int[] ranks, int cars, long mid) {
        long result = 0;
        for(int rank : ranks) {
            result += Math.sqrt(mid / rank);
        }
        return result >= cars;
    }
}
