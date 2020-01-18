class Solution {
public:
    vector<vector<int>> matrixBlockSum(vector<vector<int>>& mat, int K) {
        int subsum[101][101];
        
        for(int i=0;i<101;++i)
            for(int j=0;j<101;++j)
                subsum[i][j] = 0;
        
        int m = mat.size();
        int n = mat[0].size();
        
        for(int i=0;i<m;++i) {
            int temp = 0;
            
            for(int j=0;j<n;++j) {
                temp += mat[i][j];
                subsum[i][j] = temp;
            }
        }
                
        vector<vector<int>> ret;
        
        for(int i=0;i<m;++i) {
            vector<int> temp;
            
            for(int j=0;j<n;++j) {
                int r = 0;
                
                for(int k=-K;k<=K;++k) {
                    if(i+k < 0 || i+k >= m)
                        continue;
                    
                    int left, right;

                    if(j-(K+1) < 0)
                        left = 0;
                    else
                        left = subsum[i+k][j-(K+1)];

                    if(j+K >= n)
                        right = subsum[i+k][n-1];
                    else
                        right = subsum[i+k][j+K];
                    
                    r += (right-left);
                }
                temp.push_back(r);
            }
            
            ret.push_back(temp);
        }        
        
        return ret;
    }
};
