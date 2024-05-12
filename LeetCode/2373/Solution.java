class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;

        int[][] row = new int[n][n-2];

        for(int i=0;i<n;++i) {
            for(int j=0;j<n-2;++j) {
                row[i][j] = Math.max(Math.max(grid[i][j], grid[i][j+1]), grid[i][j+2]);
            }
        }

        int[][] result = new int[n-2][n-2];
        for(int i=0;i<n-2;++i) {
            for(int j=0;j<n-2;++j) {
                result[i][j] = Math.max(Math.max(row[i][j], row[i+1][j]), row[i+2][j]);
            }
        }
        return result;
    }
}
