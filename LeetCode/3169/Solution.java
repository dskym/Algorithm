class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->(a[0] == b[0]) ? a[1]-b[1] : a[0]-b[0]);
        int result = 0;
        int end = 0;
        for(int[] meeting : meetings) {
           if(meeting[0] >= end) {
                result += Math.max(meeting[0]-end-1, 0);
                end = meeting[1];
            } else if(meeting[0] <= end && end <= meeting[1]) {
                end = meeting[1];
            }
        }
        result += Math.max(days-end, 0);
        return result;
    }
}
