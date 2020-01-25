class Solution {
public:
    int getStatus(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        
        int ret = 0;
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                if(mat[i][j])
                    ret |= (1 << (i*m+j));
                
        return ret;
    }
    
    vector<vector<int>> makeStatus(int status, int n, int m) {
        vector<vector<int>> ret;
        
        for(int i=0;i<n;++i) {
            vector<int> temp;
            
            for(int j=0;j<m;++j) {
                temp.push_back(status % 2);
                status /= 2;
            }
            
            ret.push_back(temp);
        }
        
        return ret;
    }
    
    int minFlips(vector<vector<int>>& mat) {
        bool visited[1024];
        
        for(int i=0;i<1024;++i)
            visited[i] = false;
        
        queue<pair<int, int>> q;
        int n = mat.size();
        int m = mat[0].size();
        int direct[2][5] = {{1, -1, 0, 0, 0}, {0, 0, 1, -1, 0}};
        
        int start = getStatus(mat);

        q.push({start, 0});
        
        while(!q.empty()) {
            auto temp = q.front();
            q.pop();
            
            int status = temp.first;
            int count = temp.second;
                        
            if(status == 0)
                return count;
            
            if(visited[status])
                continue;
            
            visited[status] = true;
            
            for(int i=0;i<n;++i) {
                for(int j=0;j<m;++j) {
                    vector<vector<int>> t = makeStatus(status, n, m);
                    for(int k=0;k<5;++k) {
                        if(i+direct[0][k] >= 0 && i+direct[0][k] < n && j+direct[1][k] >= 0 && j+direct[1][k] < m) {
                            t[i+direct[0][k]][j+direct[1][k]] ^= 1;
                        }
                    }
                    
                    int nextStatus = getStatus(t);
                    q.push({nextStatus, count+1});
                }
            }
        }
        
        return -1;
    }
};
