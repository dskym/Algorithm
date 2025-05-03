class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int result = Integer.MAX_VALUE;
        for(int i=1;i<=6;++i) {
            int topSwaps = 0;
            int bottomSwaps = 0;
            boolean valid = true;
            for(int j=0;j<n;++j) {
                if(tops[j] != i && bottoms[j] != i) {
                    valid = false;
                    break;
                }
                if(tops[j] != i) {
                    topSwaps++;
                }
                if(bottoms[j] != i) {
                    bottomSwaps++;
                }
            }
            if(valid) {
                result = Math.min(result, Math.min(topSwaps, bottomSwaps));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
