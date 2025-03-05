class Solution {
    public long coloredCells(int n) {
        long result = 1;
        long base = 0;
        for(int i=0;i<n;++i) {
            result += base;
            base += 4;
        }
        return result;
    }
}
