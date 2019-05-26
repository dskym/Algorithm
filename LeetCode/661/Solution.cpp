class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& M) {
        int n = M.size();
        int m = M[0].size();
        
        vector<vector<int>> result;
        
        int direct[2][9] = {
            {0, 0, 0, 1, 1, 1, -1, -1, -1},
            {0, -1, 1, -1, 0, 1, -1, 0, 1}
        };
        
        for(int i=0;i<n;++i) {
            vector<int> temp;
            
            for(int j=0;j<m;++j) {
                int count = 0;
                int value = 0;
                
                for(int k=0;k<9;++k) {
                    int dx = i + direct[0][k];
                    int dy = j + direct[1][k];
                    
                    if(dx >= 0 && dx < n && dy >= 0 && dy < m) {
                        value += M[dx][dy];
                        count++;
                    }
                }
                
                temp.push_back((double)value / count);
            }
            result.push_back(temp);
        }
        
        return result;
    }
};
