class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int n = grid.length;
        int m = grid[0].length;
        int k = queries.length;

        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

        int[][] sorted = new int[k][2];
        for(int i=0;i<k;++i) {
            sorted[i][0] = queries[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (a,b) -> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        pq.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        int[] result = new int[k];
        for(int[] query : sorted) {
            int value = query[0];
            int index = query[1];

            while(!pq.isEmpty() && pq.peek()[0] < value) {
                int[] top = pq.poll();
                int dv = top[0];
                int x = top[1];
                int y = top[2];

                count++;

                for(int i=0;i<direct.length;++i) {
                    int dx = x+direct[i][0];
                    int dy = y+direct[i][1];

                    if(dx >= 0 && dx < n && dy >= 0 && dy < m && visited[dx][dy] == false) {
                        pq.add(new int[]{grid[dx][dy], dx, dy});
                        visited[dx][dy] = true;
                    }
                }
            }

            result[index] = count;
        }

        return result;
    }
}
