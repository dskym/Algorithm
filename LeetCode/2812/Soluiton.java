class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] dist = new int[n][n];
        int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0 ,-1}};

        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                dist[i][j] = 1000;
            }
        }

        boolean[][] visited = new boolean[n][n];
        Queue<Pair<Pos, Integer>> queue = new LinkedList<>();

        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(grid.get(i).get(j) == 1) {
                    Pos curr = new Pos(i, j);
                    queue.add(new Pair(curr, 0));
                }
            }
        }

        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            Pos c = (Pos)p.getKey();
            Integer v = (Integer)p.getValue();

            dist[c.getX()][c.getY()] = Math.min(v, dist[c.getX()][c.getY()]);
            for(int a=0;a<4;a++) {
                int dx = c.getX()+direct[a][0];
                int dy = c.getY()+direct[a][1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < n && visited[dx][dy] == false && grid.get(dx).get(dy) == 0) {
                    visited[dx][dy] = true;
                    queue.add(new Pair(new Pos(dx, dy), v+1));
                }
            }
        }

        int start = 0;
        int end = 2*n;
        int result = 0;

        while(start <= end) {
            int mid = (start+end) / 2;

            visited = new boolean[n][n];
            Queue<Pos> queue2 = new LinkedList<>();
            if(dist[0][0] >= mid) {
                queue2.add(new Pos(0, 0));
            }

            boolean flag = false;

            while(!queue2.isEmpty()) {
                Pos c = queue2.poll();

                if(c.getX() == n-1 && c.getY() == n-1) {
                    flag = true;
                    break;
                }

                for(int a=0;a<4;a++) {
                    int dx = c.getX()+direct[a][0];
                    int dy = c.getY()+direct[a][1];

                    if(dx >= 0 && dx < n && dy >= 0 && dy < n && visited[dx][dy] == false && grid.get(dx).get(dy) == 0 && dist[dx][dy] >= mid) {
                        visited[dx][dy] = true;
                        queue2.add(new Pos(dx, dy));
                    }
                }
            }

            if(flag) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return result;
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
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
