class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(n < 3 || m < 3) {
            return 0;
        }

        int result = 0;
        for(int i=1;i<n-1;++i) {
            for(int j=1;j<m-1;++j) {
                boolean flag = true;

                Set<Integer> s = new HashSet<>();
                for(int a=i-1;a<=i+1;++a) {
                    for(int b=j-1;b<=j+1;++b) {
                        s.add(grid[a][b]);
                    }
                }

                if(s.size() != 9) {
                    flag = false;
                }
                
                if(grid[i][j] != 5) {
                    flag = false;
                }

                for(int a=i-1;a<=i+1;++a) {
                    for(int b=j-1;b<=j+1;++b) {
                        if(grid[a][b] < 1 || grid[a][b] > 9) {
                            flag = false;
                        }
                    }
                }

                for(int a=i-1;a<=i+1;++a) {
                    int temp = 0;
                    for(int b=j-1;b<=j+1;++b) {
                        temp += grid[a][b];
                    }
                    if(temp != 15) {
                        flag = false;
                    }
                }

                for(int a=j-1;a<=j+1;++a) {
                    int temp = 0;
                    for(int b=i-1;b<=i+1;++b) {
                        temp += grid[b][a];
                    }
                    if(temp != 15) {
                        flag = false;
                    }
                }

                if(!flag) {
                    continue;
                }

                result++;
            }
        }
        return result;
    }
}
