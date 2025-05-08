class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] dp = new int[n][m];
        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0,0});
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int time = node[2];
            int next = node[3];

            dp[x][y] = time;

            for(int i=0;i<4;++i) {
                int dx = x + direct[i][1];
                int dy = y + direct[i][0];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && visited[dx][dy] == false) {
                    int newTime = Math.max(moveTime[dx][dy], dp[x][y])+1+next;
                    pq.add(new int[]{dx,dy,newTime,1-next});
                    visited[dx][dy] = true;
                }
            }
        }

        return dp[n-1][m-1];
    }
}
