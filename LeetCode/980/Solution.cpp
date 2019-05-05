class Solution {
public:
    int direct[4][2] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    bool visited[21][21];
    int count = 0;
    
    void dfs(vector<vector<int>>& grid, int x, int y, int n, int m, int walk) {
        if(grid[x][y] == 2 && walk == 0) {
            count++;            
            return;
        }
        
        for(int i=0;i<4;++i) {
            int dx = x + direct[i][0];
            int dy = y + direct[i][1];
            
            if(dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy] && (grid[dx][dy] == 0 || grid[dx][dy] == 2)) {
                visited[dx][dy] = true;
                dfs(grid, dx, dy, n, m, walk - 1);
                visited[dx][dy] = false;
            }
        }
    }
    
    int uniquePathsIII(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                visited[i][j] = false;

        int total = 0;

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] != -1)
                    total++;
            }
        }
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] == 1) {
                    visited[i][j] = true;
                    dfs(grid, i, j, n, m, total - 1);
                }
            }
        }
        
        return count;
    }
};
