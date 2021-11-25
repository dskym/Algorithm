class Solution {
public:
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int ret = 0;
        
        bool visited[501][501];
        
        for(int i=0;i<501;++i)
            for(int j=0;j<501;++j)
                visited[i][j] = false;
        
        int m = grid1.size();
        int n = grid1[0].size();
        
        int direct[4][2] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for(int i=0;i<m;++i) {
            for(int j=0;j<n;++j) {
                if(grid2[i][j] == 1 && visited[i][j] == false) {
                    bool flag = true;
                    queue<pair<int,int>> q;
                    q.push({i, j});
                    visited[i][j] = true;
                    
                    while(!q.empty()) {
                        auto t = q.front();
                        q.pop();
                        
                        int x = t.first;
                        int y = t.second;
                        
                        if(grid1[x][y] == 0) {
                            flag = false;
                        }
                        
                        for(int i=0;i<4;++i) {
                            if(x + direct[i][0] >= 0 && x + direct[i][0] < m && y + direct[i][1] >= 0  && y + direct[i][1] < n && visited[x + direct[i][0]][y + direct[i][1]] == false && grid2[x + direct[i][0]][y + direct[i][1]] == 1) {
                                q.push({x + direct[i][0], y + direct[i][1]});
                                visited[x + direct[i][0]][y + direct[i][1]] = true;
                            }
                        }                        
                    }
                    if(flag) {
                        ret++;
                    }
                }
            }
        }
        
        return ret;
    }
};
