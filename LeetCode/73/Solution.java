class Solution {
    public void setZeroes(int[][] matrix) {
        int[] row = new int[8];
        int[] col = new int[8];

        for(int i=0;i<matrix.length;++i) {
            for(int j=0;j<matrix[0].length;++j) {
                if(matrix[i][j] == 0) {
                    row[i/32] |= 1 << i;
                    col[j/32] |= 1 << j;
                }
            }
        }

        for(int i=0;i<matrix.length;++i) {
            for(int j=0;j<matrix[0].length;++j) {
                int rowFlag = row[i/32] & (1 << i);
                int colFlag = col[j/32] & (1 << j);

                if(rowFlag != 0) {
                    matrix[i][j] = 0;
                }
                if(colFlag != 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
