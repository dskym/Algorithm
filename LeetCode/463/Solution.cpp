class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int count = 0;
        int overlap = 0;
        
        int n = grid.size();
        int m = grid[0].size();
        
        int direct[2][4] = {{0, 0, 1, -1}, {-1, 1, 0, 0}};
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(grid[i][j] == 1) {
                    count++;
                
                    for(int k=0;k<4;++k) {
                        int dx = i + direct[0][k];
                        int dy = j + direct[1][k];

                        if(dx >= 0 && dx < n && dy >= 0 && dy < m && grid[dx][dy] == 1)
                            overlap++;
                    }
                }
            }
        }
        
        return count * 4 - overlap;
    }
};
