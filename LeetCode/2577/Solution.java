class Solution {
    public int minimumTime(int[][] grid) {
        int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        boolean[][] visited = new boolean[n][m];

        pq.add(new int[]{0,0,0});
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int x = curr[1];
            int y = curr[2];

            for(int i=0;i<direct.length;++i) {
                int dx = x+direct[i][0];
                int dy = y+direct[i][1];

                if(dx < 0 || dx >= n || dy < 0 || dy >= m || visited[dx][dy]) {
                    continue;
                }

                int newTime = time+1;
                if(grid[dx][dy] > newTime) {
                    int wait = ((grid[dx][dy] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if(dx == n-1 && dy == m-1) {
                    return newTime;
                }

                visited[dx][dy] = true;
                pq.add(new int[]{newTime, dx, dy});
            }
        }
        return -1;
    }
}
