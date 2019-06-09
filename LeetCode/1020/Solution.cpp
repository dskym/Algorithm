class Solution {
public:
    int numEnclaves(vector<vector<int>>& A) {
        int n = A.size();
        int m = A[0].size();
        
        int direct[2][4] = {{0, 0, 1, -1}, {-1, 1, 0, 0}};
    
        for(int i=0;i<m;++i) {
            if(A[0][i] == 1) {
                queue<pair<int, int>> q;
                
                q.push({0, i});
                A[0][i] = 0;
                
                while(!q.empty()) {
                    auto pos = q.front();
                    q.pop();
                    
                    int x = pos.first;
                    int y = pos.second;
                    
                    for(int i=0;i<4;++i) {
                        int dx = x + direct[0][i];
                        int dy = y + direct[1][i];
                        
                        if(dx >= 0 && dx < n - 1 && dy >= 0 && dy < m - 1 && A[dx][dy] == 1) {
                            q.push({dx, dy});
                            A[dx][dy] = 0;
                        }
                    }
                }
            }
            
            if(A[n-1][i] == 1) {
                queue<pair<int, int>> q;
                
                q.push({n-1, i});
                A[n-1][i] = 0;
                
                while(!q.empty()) {
                    auto pos = q.front();
                    q.pop();
                    
                    int x = pos.first;
                    int y = pos.second;
                    
                    for(int i=0;i<4;++i) {
                        int dx = x + direct[0][i];
                        int dy = y + direct[1][i];
                        
                        if(dx >= 0 && dx < n - 1 && dy >= 0 && dy < m - 1 && A[dx][dy] == 1) {
                            q.push({dx, dy});
                            A[dx][dy] = 0;
                        }
                    }
                }
            }
        }

        for(int i=0;i<n;++i) {
            if(A[i][0] == 1) {
                queue<pair<int, int>> q;
                
                q.push({i, 0});
                A[i][0] = 0;
                
                while(!q.empty()) {
                    auto pos = q.front();
                    q.pop();
                    
                    int x = pos.first;
                    int y = pos.second;
                    
                    for(int i=0;i<4;++i) {
                        int dx = x + direct[0][i];
                        int dy = y + direct[1][i];
                        
                        if(dx >= 0 && dx < n - 1 && dy >= 0 && dy < m - 1 && A[dx][dy] == 1) {
                            q.push({dx, dy});
                            A[dx][dy] = 0;
                        }
                    }
                }
            }
            
            if(A[i][m-1] == 1) {
                queue<pair<int, int>> q;
                
                q.push({i, m-1});
                A[i][m-1] = 0;
                
                while(!q.empty()) {
                    auto pos = q.front();
                    q.pop();
                    
                    int x = pos.first;
                    int y = pos.second;
                    
                    for(int i=0;i<4;++i) {
                        int dx = x + direct[0][i];
                        int dy = y + direct[1][i];
                        
                        if(dx >= 0 && dx < n - 1 && dy >= 0 && dy < m - 1 && A[dx][dy] == 1) {
                            q.push({dx, dy});
                            A[dx][dy] = 0;
                        }
                    }
                }
            }
        }
        
        int result = 0;
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                if(A[i][j] == 1)
                    result++;

        return result;
    }
};
