class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<m;++i) {
            if(grid[i][0] == 0) {
                for(int j=0;j<n;++j) {
                    if(grid[i][j] == 0) {
                        grid[i][j] = 1;
                    } else {
                        grid[i][j] = 0;
                    }
                }
            }
        }

        for(int i=0;i<n;++i) {
            int count = 0;
            for(int j=0;j<m;++j) {
                if(grid[j][i] == 1) {
                    count++;
                }
            }

            if(count <= m/2) {
                for(int j=0;j<m;++j) {
                    if(grid[j][i] == 0) {
                        grid[j][i] = 1;
                    } else {
                        grid[j][i] = 0;
                    }
                }
            }
        }

        int result = 0;
        int base = 1;
        for(int i=n-1;i>=0;--i) {
            for(int j=0;j<m;++j) {
                result += base * grid[j][i];
            }
            base *= 2;
        }
        return result;
    }
}

