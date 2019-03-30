class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        int** map;
        
        map = new int*[n];
        
        for(int i=0;i<n;++i)
            map[i] = new int[m];
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                map[i][j] = 0;
        
        map[0][0] = grid[0][0];
        
        for(int i=1;i<m;++i)
            map[0][i] = map[0][i-1] + grid[0][i];
            
        for(int i=1;i<n;++i)
            map[i][0] = map[i-1][0] + grid[i][0];
        
        for(int i=1;i<n;++i)
            for(int j=1;j<m;++j)
                map[i][j] = min(map[i-1][j], map[i][j-1]) + grid[i][j];
        
        return map[n-1][m-1];
    }
};
