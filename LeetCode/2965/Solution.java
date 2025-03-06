class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        int n = grid.length;

        int[] temp = new int[n*n+1];
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                temp[grid[i][j]]++;
                if(temp[grid[i][j]] > 1) {
                    result[0] = grid[i][j];
                }
            }
        }

        for(int i=1;i<=n*n;++i) {
            if(temp[i] == 0) {
                result[1] = i;
            }
        }

        return result;
    }
}
