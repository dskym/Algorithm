class Solution {
public:
    int dp[1001];
    int solve(int pos, vector<int>& cost) {
        if(pos >= cost.size())
            return 0;
        
        if(dp[pos] != 1000000000)
            return dp[pos];

        dp[pos] = min(solve(pos+1, cost), solve(pos+2, cost))+cost[pos];
        
        return dp[pos];
    }
    int minCostClimbingStairs(vector<int>& cost) {
        for(int i=0;i<1001;++i)
            dp[i] = 1000000000;
        return min(solve(0, cost), solve(1, cost));
    }
};
