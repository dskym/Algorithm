class Solution {
public:
    bool visited[51][51];
    
    int count(vector<vector<int>>& grid, int r, int c, int n, int m) {
        int result = 0;
        
        if(r-1 >= 0 && grid[r-1][c] == 1 && visited[r-1][c] == false) {
            visited[r-1][c] = true;
            result += count(grid, r-1, c, n, m) + 1;
        }
        
        if(r+1 < n && grid[r+1][c] == 1 && visited[r+1][c] == false) {
            visited[r+1][c] = true;
            result += count(grid, r+1, c, n, m) + 1;
        }

        if(c-1 >= 0 && grid[r][c-1] == 1 && visited[r][c-1] == false) {
            visited[r][c-1] = true;
            result += count(grid, r, c-1, n, m) + 1;
        }

        if(c+1 < m && grid[r][c+1] == 1 && visited[r][c+1] == false) {
            visited[r][c+1] = true;
            result += count(grid, r, c+1, n, m) + 1;
        }

        
        return result;
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int result = 0;
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i=0;i<51;++i)
            for(int j=0;j<51;++j)
                visited[i][j] = false;
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    visited[i][j] = true;
                    result = max(result, count(grid, i, j, n, m) + 1);
                }
            }
        }
        
        return result;
    }
};
