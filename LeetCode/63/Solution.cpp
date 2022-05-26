class Solution {
public:
    int dp[101][101];
    int solve(vector<vector<int>>& obstacleGrid, vector<vector<bool>>& visited, int x, int y, int n, int m) {
        if(x == n-1 && y == m-1) {
            return 1;
        }
        
        if(dp[x][y] != -1)
            return dp[x][y];
        
        int result = 0;

        visited[x][y] = true;
        if(x+1 < n && y < m && obstacleGrid[x+1][y] == 0 && visited[x+1][y] == false) {
            result += solve(obstacleGrid, visited, x+1, y, n, m);
        }
        
        if(x < n && y+1 < m && obstacleGrid[x][y+1] == 0 && visited[x][y+1] == false) {
            result += solve(obstacleGrid, visited, x, y+1, n, m);
        }
        visited[x][y] = false;
        
        dp[x][y] = result;

        return result;
    }
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<vector<bool>> visited;
        
        for(int i=0;i<101;++i) {
            vector<bool> temp;
            for(int j=0;j<101;++j) {            
                temp.push_back(false);
                dp[i][j] = -1;
            }
            visited.push_back(temp);
        }
        
        int n = obstacleGrid.size();
        int m = obstacleGrid[0].size();
        
        if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1)
            return 0;
        
        return solve(obstacleGrid, visited, 0, 0, n, m);
    }
};
