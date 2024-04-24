class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] direct = {{1,1}, {1,0}, {1,-1}, {0,1}, {0,-1}, {-1,1}, {-1,0}, {-1,-1}};

        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                int lives = 0;
                for(int k=0;k<direct.length;++k) {
                    int dx = i+direct[k][0];
                    int dy = j+direct[k][1];

                    if(dx >= 0 && dx < m && dy >= 0 && dy < n) {
                        if((board[dx][dy] & 1) == 1) {
                            lives++;
                        }
                    }
                }
                if((board[i][j] & 1) == 1 && (lives == 2 || lives == 3)) {
                    board[i][j] |= 2;
                } else if((board[i][j] & 1) == 0 && lives == 3) {
                    board[i][j] |= 2;
                }
            }
        }

        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                board[i][j] = (board[i][j] & 2) >> 1;
            }
        }
    }
}
