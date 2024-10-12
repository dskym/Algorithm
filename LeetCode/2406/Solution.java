class Solution {
    public int minGroups(int[][] intervals) {
        int[] count = new int[1000002];

        for(int i=0;i<intervals.length;++i) {
            count[intervals[i][0]]++;
            count[intervals[i][1]+1]--;
        }

        int result = 0;
        int curr = 0;
        for(int i=1;i<=1000000;++i) {
            curr += count[i];
            result = Math.max(result, curr);
        }
        return result;
    }
}
