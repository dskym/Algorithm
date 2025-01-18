class Solution {
    public int minCost(int[][] grid) {
        int[][] direct = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][][] visited = new boolean[101][101][10001];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;

        int n = grid.length;
        int m = grid[0].length;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();

            if(n-1 == node[0] && m-1 == node[1]) {
                return node[2];
            }
            
            for(int i=0;i<4;++i) {
                int dx = node[0] + direct[i][0];
                int dy = node[1] + direct[i][1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m) {
                    if(i+1 == grid[node[0]][node[1]] && visited[dx][dy][node[2]] == false) {
                        pq.add(new int[]{dx, dy, node[2]});
                        visited[dx][dy][node[2]] = true;
                    } else if(visited[dx][dy][node[2]+1] == false) {
                        pq.add(new int[]{dx, dy, node[2]+1});
                        visited[dx][dy][node[2]+1] = true;
                    }
                }
            }
        }
        return 0;
    }
}
