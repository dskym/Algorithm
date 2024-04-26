class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Pos> queue = new LinkedList<>();
        int[][] direct = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i=0;i<m;++i) {
            if(board[i][0] == 'O') {
                board[i][0] = 'a';
                queue.add(new Pos(i, 0));
                visited[i][0] = true;
            }
            if(board[i][n-1] == 'O') {
                board[i][n-1] = 'a';
                queue.add(new Pos(i, n-1));
                visited[i][n-1] = true;
            }
        }
        for(int i=0;i<n;++i) {
            if(board[0][i] == 'O') {
                board[0][i] = 'a';
                queue.add(new Pos(0, i));
                visited[0][i] = true;
            }
            if(board[m-1][i] == 'O') {
                board[m-1][i] = 'a';
                queue.add(new Pos(m-1, i));
                visited[m-1][i] = true;
            }
        }

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();

            for(int i=0;i<direct.length;++i) {
                int dx = pos.getX() + direct[i][0];
                int dy = pos.getY() + direct[i][1];

                if(dx >= 0 && dx < m && dy >= 0 && dy < n && board[dx][dy] == 'O' && visited[dx][dy] == false) {
                    board[dx][dy] = 'a';
                    queue.add(new Pos(dx, dy));
                    visited[dx][dy] = true;
                }
            }
        }

        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                if(board[i][j] == 'a') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

class Pos {
    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
