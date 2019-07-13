class Solution {
public:
    bool swim(vector<vector<int>>& grid, int depth) {
        int n = grid.size();
        
        bool visited[51][51];
        
        for(int i=0;i<n;++i)
            for(int j=0;j<n;++j)
                visited[i][j] = false;
        
        queue<pair<int, int>> q;
        int direct[2][4] = {{0, 0, -1, 1}, {1, -1, 0, 0}};
        
        q.push({0, 0});
        visited[0][0] = true;
        
        while(!q.empty()) {
            auto pos = q.front();
            q.pop();
            
            int x = pos.first;
            int y = pos.second;
            
            if(x == n-1 && y == n-1)
                return true;
            
            for(int i=0;i<4;++i) {
                int dx = x + direct[0][i];
                int dy = y + direct[1][i];
                
                if(0 <= dx && dx < n && 0 <= dy && dy < n && visited[dx][dy] == false && grid[dx][dy] <= depth) {
                    q.push({dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }
        
        return false;
    }
    
    int swimInWater(vector<vector<int>>& grid) {
        int n = grid.size();
        
        int start = grid[0][0];
        int end = 3000;
        int mid;
        bool flag;
        
        while(start <= end) {
            mid = (start + end) / 2;

            flag = swim(grid, mid);
            
            if(flag == false)
                start = mid + 1;
            else
                end = mid - 1;
            
        }
                
        if(flag == true)
            return mid;
        else
            return mid+1;
    }
};
