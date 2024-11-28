class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
        int[][] dist = new int[n][m];
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        dist[0][0] = 0;
        queue.add(new Pair(0, 0));

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> v = queue.poll();
            int x = v.getKey();
            int y = v.getValue();

            for(int i=0;i<direct.length;++i) {
                int dx = x + direct[i][0];
                int dy = y + direct[i][1];

                if(0 <= dx && dx < n && 0 <= dy && dy < m) {
                    int d = dist[x][y] + grid[dx][dy];
                    if(d < dist[dx][dy]) {
                        dist[dx][dy] = d;
                        queue.add(new Pair(dx, dy));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
