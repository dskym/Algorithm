class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

        int result = 0;
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(visited[i][j] || grid[i][j] == 0) {
                    continue;
                }

                int temp = 0;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                while(!q.isEmpty()) {
                    int[] pos = q.poll();
                    int x = pos[0];
                    int y = pos[1];

                    temp += grid[x][y];

                    for(int k=0;k<4;++k) {
                        int dx = x+direct[k][0];
                        int dy = y+direct[k][1];
                        
                        if(dx >= 0 && dx < n && dy >= 0 && dy < m && visited[dx][dy] == false && grid[dx][dy] != 0) {
                            q.add(new int[]{dx, dy});
                            visited[dx][dy] = true;
                        }
                    }
                }

                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
