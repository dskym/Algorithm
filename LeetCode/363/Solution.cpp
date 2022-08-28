class Solution {
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int dp[101][101];
        for(int i=0;i<101;++i) {
            for(int j=0;j<101;++j) {
                dp[i][j]=0;
            }
        }
        
        int m = matrix.size();
        int n = matrix[0].size();

        dp[0][0] = matrix[0][0];
        for(int i=1;i<n;++i) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }
        for(int i=1;i<m;++i) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for(int i=1;i<m;++i) {
            for(int j=1;j<n;++j) {
                dp[i][j] = matrix[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }
        
        int ret = -999999999;        
        for(int a=0;a<m;++a) {
            for(int b=0;b<n;++b) {
                for(int c=a;c<m;++c) {
                    for(int d=b;d<n;++d) {
                        int temp;
                        if(a == 0 && b == 0) {
                            temp = dp[c][d];
                        } else if(a == 0) {
                            temp = dp[c][d] - dp[c][b-1];
                        } else if(b == 0) {
                            temp = dp[c][d] - dp[a-1][d];
                        } else {
                            temp = dp[c][d] + dp[a-1][b-1] - dp[a-1][d] - dp[c][b-1];
                        }
                        if(temp <= k) {
                            ret = max(ret, temp);
                        }
                    }
                }
            }
        }
        return ret;
    }
};
