class Solution {
public:
    int dp[501][501];
    int solve(int index1, int index2, string word1, string word2) {
        if(dp[index1][index2] != 100000000)
            return dp[index1][index2];
        
        if(word1.size() <= index1) {
            return word2.size()-index2;
        }
        if(word2.size() <= index2) {
            return word1.size()-index1;
        }

        if(word1[index1] == word2[index2]) {
            dp[index1][index2] = min(dp[index1][index2], solve(index1+1, index2+1, word1, word2));
            
            return dp[index1][index2];
        } else {
            int temp1 = solve(index1+1, index2, word1, word2) + 1;
            int temp2 = solve(index1, index2+1, word1, word2) + 1;
            dp[index1][index2] = min(dp[index1][index2], min(temp1, temp2));
            return dp[index1][index2];
        }
        
        return 0;
    }
    int minDistance(string word1, string word2) {
        for(int i=0;i<501;++i)
            for(int j=0;j<501;++j)
                dp[i][j] = 100000000;
        return solve(0, 0 ,word1, word2);
    }
};
