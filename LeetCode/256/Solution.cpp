class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int dp[101][3];
        int n = costs.size();
        
        for(int i=0;i<101;++i)
            for(int j=0;j<3;++j)
                dp[i][j] = 10000000000;

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for(int i=1;i<n;++i) {
            for(int j=0;j<3;++j) {
                for(int k=1;k<=2;++k) {
                    dp[i][j] = min(dp[i][j], costs[i][j] + dp[i-1][(j+k)%3]);
                }
            }
        }
        
        int ret = 10000000000;        
        for(int i=0;i<3;++i) {
            ret = min(ret, dp[n-1][i]);
        }
        return ret;
    }
};

