class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] direct = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] result = new int[n][m];
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i=0;i<4;++i) {
                int dx = pos[0]+direct[i][0];
                int dy = pos[1]+direct[i][1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && visited[dx][dy] == false) {
                    result[dx][dy] = Math.max(result[dx][dy], result[x][y]+1);
                    q.add(new int[]{dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }
        return result;
    }
}
