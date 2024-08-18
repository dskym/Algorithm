class Solution {
    public int minDays(int[][] grid) {
        if(countIslands(grid) != 1) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if(countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    public int countIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] direct = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        boolean[][] visited = new boolean[n][m];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        
        int count = 0;

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    count++;
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                    while(!q.isEmpty()) {
                        var top = q.poll();
                        int x = top.getKey();
                        int y = top.getValue();

                        for(int a=0;a<direct.length;++a) {
                            int dx = x+direct[a][0];
                            int dy = y+direct[a][1];

                            if(dx >= 0 && dx < n && dy >= 0 && dy < m && grid[dx][dy] == 1 && visited[dx][dy] == false) {
                                q.add(new Pair(dx, dy));
                                visited[dx][dy] = true;
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
