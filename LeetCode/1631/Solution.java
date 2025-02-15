class Solution {
    public int minimumEffortPath(int[][] heights) {
        int start = 0;
        int end = 1000000;
        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};
        int n = heights.length;
        int m = heights[0].length;

        while(start < end) {
            int mid = (start+end)/2;

            boolean[][] visited = new boolean[n][m];

            Queue<Pair<Integer,Integer>> q = new LinkedList<>();
            visited[0][0] = true;
            q.add(new Pair(0,0));

            boolean check = false;

            while(!q.isEmpty()) {
                Pair<Integer, Integer> pair = q.poll();
                int x = pair.getKey();
                int y = pair.getValue();

                if(x == n-1 && y == m-1) {
                    check = true;
                    break;
                }

                for(int i=0;i<4;++i) {
                    int dx = x+direct[i][0];
                    int dy = y+direct[i][1];

                    if(dx >= 0 && dx < n && dy >= 0 && dy < m && visited[dx][dy] == false && Math.abs(heights[x][y]-heights[dx][dy]) <= mid) {
                        q.add(new Pair(dx,dy));
                        visited[dx][dy] = true;
                    }
                }
            }

            if(check) {
                end = mid;
            } else {
                start = mid+1;
            }
        }

        return end;
    }
}
