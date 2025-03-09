class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int result = 0;
        int count = 1;
        int base = colors[0];
        for(int i=1;i<n+k-1;++i) {
            if(colors[i % n] == base) {
                count = 1;
                base = colors[i % n];
                continue;
            }

            count++;

            if(count >= k) {
                result++;
            }

            base = colors[i % n];
        }
        return result;
    }
}
