class Solution {
private:
    int dp[20001];
    bool visited[20001];
public:
    int solve(int index, vector<int>& nums, int sum) {
        if(visited[index] == true)
            return sum;

        visited[index] = true;
        dp[index] = solve(nums[index], nums, sum + 1);
        
        return dp[index];
    }
    
    int arrayNesting(vector<int>& nums) {
        
        for(int i=0;i<20001;i++) {
            dp[i] = -1;
            visited[i] = false;
        }
        
        for(int i=0;i<nums.size();++i)
            solve(i, nums, 0);
        
        int result = dp[0];

        for(int i=1;i<nums.size();++i)
            result = (dp[i] > result) ? dp[i] : result;

        return result;
    }
};
