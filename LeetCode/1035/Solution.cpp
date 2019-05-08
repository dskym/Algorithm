class Solution {
public:
    int maxUncrossedLines(vector<int>& A, vector<int>& B) {
        int n = A.size();
        int m = B.size();
        
        int dp[501][501];
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                dp[i][j] = 0;
        
        if(A[0] == B[0])
            dp[0][0] = 1;
        else
            dp[0][0] = 0;

        for(int i=1;i<n;++i) {
            if(A[i] == B[0])
                dp[i][0] = 1;
            else
                dp[i][0] = dp[i-1][0];
        }
        
        for(int i=1;i<m;++i) {
            if(A[0] == B[i])
                dp[0][i] = 1;
            else
                dp[0][i] = dp[0][i-1];
        }
        
        for(int i=1;i<n;++i) {
            for(int j=1;j<m;++j) {
                if(A[i] == B[j])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }        
        }        
       
        return dp[n-1][m-1];
    }
};
