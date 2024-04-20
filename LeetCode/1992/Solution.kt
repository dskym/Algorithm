class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Pos> queue = new LinkedList<>();
        int[][] direct = new int[][] {{1,0}, {0, 1}};

        List<int[]> result = new ArrayList<>();

        int index = 0;

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(land[i][j] == 1 && visited[i][j] == false) {
                    System.out.println(i + ", " + j);
                    visited[i][j] = true;
                    queue.add(new Pos(i, j));

                    int lastX = i;
                    int lastY = j;

                    while(!queue.isEmpty()) {
                        Pos p = queue.poll();

                        int x = p.getX();
                        int y = p.getY();

                        for(int k=0;k<direct.length;++k) {
                            int dx = x+direct[k][0];
                            int dy = y+direct[k][1];

                            if(dx >= 0 && dx < n && dy >= 0 && dy < m && land[dx][dy] == 1 && visited[dx][dy] == false) {
                                queue.add(new Pos(dx, dy));
                                visited[dx][dy] = true;
                                lastX = dx;
                                lastY = dy;
                            }
                        }
                    }

                    result.add(new int[]{i, j, lastX, lastY});
                }
            }
        }

        return result.toArray(new int[result.size()][]);
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
