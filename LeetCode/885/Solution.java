class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int direct = 1;
        int step = 1;
        int remainStep = step;
        int count = 1;
        int n = rows*cols;

        int[][] result = new int[n][2];
        result[0][0] = rStart;
        result[0][1] = cStart;

        while(count != n) {
            int[] temp = new int[2];

            if(direct == 1) { // right
                cStart++;
                
                remainStep--;
                if(remainStep == 0) {
                    direct = 2;
                    remainStep = step;
                }
            } else if(direct == 2) { // bottom
                rStart++;

                remainStep--;
                if(remainStep == 0) {
                    direct = 3;
                    step++;
                    remainStep = step;
                }
            } else if(direct == 3) { //left
                cStart--;

                remainStep--;
                if(remainStep == 0) {
                    direct = 4;
                    remainStep = step;
                }
            } else { // up
                rStart--;

                remainStep--;
                if(remainStep == 0) {
                    direct = 1;
                    step++;
                    remainStep = step;
                }
            }

            if(cStart < 0 || cStart >= cols || rStart < 0 || rStart >= rows) {
                continue;
            }

            result[count][0] = rStart;
            result[count][1] = cStart;
            count++;
        }
        return result;
    }
}
