class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int result = 0;
        int maxSize = Math.min(n, m);
        for(int i=1;i<=maxSize;++i) {
            for(int x=0;x<n-i+1;++x) {
                for(int y=0;y<m-i+1;++y) {
                    if(isSquare(matrix, x, y, i)) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }

    private boolean isSquare(int[][] matrix, int x, int y, int n) {
        for(int i=x;i<x+n;++i) {
            for(int j=y;j<y+n;++j) {
                if(matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
