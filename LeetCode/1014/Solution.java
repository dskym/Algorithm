class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int left = values[0];
        int result = 0;
        for(int i=1;i<values.length;++i) {
            result = Math.max(result, left+values[i]-i);
            left = Math.max(left, values[i]+i);
        }

        return result;
    }
}
