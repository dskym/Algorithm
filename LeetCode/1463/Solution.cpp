class Solution {
public:
    int dp[101][101][101];

    int solve(vector<vector<int>>& grid, int x1, int y1, int x2, int y2, int n, int m) {
        if(n-1 == x1 && n-1 == x2) {
            dp[x1][y1][y2] = grid[x1][y1] + grid[x2][y2];
            return grid[x1][y1] + grid[x2][y2];
        }

        int direct[3][2] = {{1, -1}, {1, 0}, {1, 1}};
        int ret = grid[x1][y1] + grid[x2][y2];
        int temp = 0;
        for(int i=0;i<3;++i) {
            for(int j=0;j<3;++j) {
                int dx1 = x1+direct[i][0];
                int dy1 = y1+direct[i][1];
                int dx2 = x2+direct[j][0];
                int dy2 = y2+direct[j][1];

                if(dx1 >= 0 && dx1 < n && dy1 >= 0 && dy1 < m && dx2 >= 0 && dx2 < n && dy2 >= 0 && dy2 < m && dy1 != dy2) {
                    if(dp[dx1][dy1][dy2] != -1) {
                        temp = max(temp, dp[dx1][dy1][dy2]);
                    } else {
                        temp = max(temp, solve(grid, dx1, dy1, dx2, dy2, n, m));
                    }
                }
            }
        }
        dp[x1][y1][y2] = temp + ret;
        return temp + ret;
    }
    int cherryPickup(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                for(int k=0;k<m;++k) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return solve(grid, 0, 0, 0, m-1, n, m);
    }
};
