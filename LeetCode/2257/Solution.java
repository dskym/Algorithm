class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] map = new int[m][n];

        for(int i=0;i<walls.length;++i) {
            map[walls[i][0]][walls[i][1]] = 1;
        }

        for(int i=0;i<guards.length;++i) {
            map[guards[i][0]][guards[i][1]] = 2;
        }

        for(int i=0;i<guards.length;++i) {
            int x = guards[i][0];
            int y = guards[i][1];

            for(int j=x+1;j<m;++j) {
                if(map[j][y] == 0 || map[j][y] == 3) {
                    map[j][y] = 3;
                } else {
                    break;
                }
            }

            for(int j=x-1;j>=0;--j) {
                if(map[j][y] == 0 || map[j][y] == 3) {
                    map[j][y] = 3;
                } else {
                    break;
                }
            }

            for(int j=y+1;j<n;++j) {
                if(map[x][j] == 0 || map[x][j] == 3) {
                    map[x][j] = 3;
                } else {
                    break;
                }
            }

            for(int j=y-1;j>=0;--j) {
                if(map[x][j] == 0 || map[x][j] == 3) {
                    map[x][j] = 3;
                } else {
                    break;
                }
            }
        }

        int result = 0;
        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                if(map[i][j] == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
