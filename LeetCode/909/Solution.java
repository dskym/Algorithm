class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Map<Integer, Pair<Integer, Integer>> m = new HashMap<>();
        int index = 1;
        for(int i=n-1;i>=0;--i) {
            if((index / n) % 2 == 0) {
                for(int j=0;j<n;++j) {
                    m.put(index++, new Pair(i, j));
                }
            } else {
                for(int j=n-1;j>=0;--j) {
                    m.put(index++, new Pair(i, j));
                }
            }
        }

        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{1, 0});
        visited[n-1][0] = true;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int curr = node[0];
            int count = node[1];

            if(curr == n*n) {
                return count;
            }

            for(int i=1;i<=6;++i) {
                int next = curr+i;
                if(m.get(next) != null) {
                    int x = m.get(next).getKey();
                    int y = m.get(next).getValue();
                    if(board[x][y] != -1) {
                        if(m.get(board[x][y]) != null) {
                            int dx = m.get(board[x][y]).getKey();
                            int dy = m.get(board[x][y]).getValue();
                            if(visited[dx][dy] == false) {
                                pq.add(new int[]{board[x][y], count+1});
                                visited[dx][dy] = true;
                            }
                        }
                    } else {
                        if(visited[x][y] == false) {
                            pq.add(new int[]{next, count+1});
                            visited[x][y] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
