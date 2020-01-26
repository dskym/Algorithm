class Solution {
public:
    int solve(vector<vector<int>>& grid, int x, int y, int n, int m, bool visited[15][15]) {
        int direct[2][4] = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        int ret = 0;

        for(int i=0;i<4;++i) {
            int dx = x+direct[0][i];
            int dy = y+direct[1][i];
            
            if(dx >= 0 && dx < n && dy >= 0 && dy < m && grid[dx][dy] != 0 && visited[dx][dy] == false) {
                visited[dx][dy] = true;
                ret = max(ret, solve(grid, dx, dy, n, m, visited)+grid[dx][dy]);
                visited[dx][dy] = false;
            }
        }
        
        return ret;
    }
    
    int getMaximumGold(vector<vector<int>>& grid) {
        bool visited[15][15];
        
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                visited[i][j] = false;
        
        int ret = 0;
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                if(grid[i][j] != 0) {
                    visited[i][j] = true;
                    ret = max(ret, solve(grid, i, j, n, m, visited)+grid[i][j]);
                    visited[i][j] = false;
                }
        
        return ret;
    }
};
