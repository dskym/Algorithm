class Solution {
public:
    int dp[101][101];
    
    int solve(vector<vector<int>>& A, int row, int col) {
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int n = A.size();
        
        if(row == n)
            return 0;

        int sum = A[row][col] + solve(A, row+1, col);
        
        if(col-1 >= 0)
            sum = min(sum, A[row][col] + solve(A, row+1, col-1));

        if(col+1 < n)
            sum = min(sum, A[row][col] + solve(A, row+1, col+1));
        
        dp[row][col] = sum;
        
        return sum;
    }
    
    int minFallingPathSum(vector<vector<int>>& A) {
        int n = A.size();
        
        for(int i=0;i<101;++i) {
            for(int j=0;j<101;++j) {
                dp[i][j] = -1;
            }
        }
        
        int result = 20000;
        
        for(int i=0;i<n;++i)
            result = min(result, solve(A, 0, i));
        
        return result;
    }
};
