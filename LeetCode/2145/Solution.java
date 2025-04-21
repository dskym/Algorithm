class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int n = differences.length;

        int top = 0;
        int bottom = 0;
        int cur = 0;

        for(int i=0;i<n;++i) {
            cur += differences[i];

            top = Math.max(cur, top);
            bottom = Math.min(cur, bottom);

            if(top-bottom > upper-lower) {
                return 0;
            }
        }

        return (upper-lower+1)-(top-bottom);
    }
}
