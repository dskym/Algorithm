class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        int dp[101][101];
        for(int i=0;i<101;++i) {
            for(int j=0;j<101;++j) {
                dp[i][j] = 0;
            }            
        }
        
        int n = matrix.size();
        int m = matrix[0].size();
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(i == 0 && j == 0)
                    dp[i][j] = matrix[i][j];
                else if(i == 0) {
                    dp[i][j] = dp[i][j-1] + matrix[i][j];
                } else if(j == 0) {
                    dp[i][j] = dp[i-1][j] + matrix[i][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
                }
            }            
        }
        
        int ret = 0;
        for(int x2=0;x2<n;++x2) {
            for(int y2=0;y2<m;++y2) {
                for(int x1=0;x1<=x2;++x1) {
                    for(int y1=0;y1<=y2;++y1) {
                        int size;
                        if(x1 == 0 && y1 == 0) {
                            size = dp[x2][y2];
                        } else if(x1 == 0) {
                            size = dp[x2][y2]- dp[x2][y1-1];
                        } else if(y1 == 0) {
                            size = dp[x2][y2] - dp[x1-1][y2];
                        } else {
                            size = dp[x2][y2] + dp[x1-1][y1-1] - dp[x1-1][y2] - dp[x2][y1-1];
                        }
                        if(size == target)
                            ret++;
                    }
                }
            }
        }
        return ret;
    }
};
