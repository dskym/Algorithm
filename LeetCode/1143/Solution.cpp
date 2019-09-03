class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        int count[1001][1001];
        
        int n = text1.length();
        int m = text2.length();
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                count[i][j] = 0;

        if(text1[0] == text2[0])
            count[0][0] = 1;
        
        for(int i=1;i<n;++i) {
            if(text2[0] == text1[i])
                count[i][0] = 1;
            else
                count[i][0] = count[i-1][0];
        }
        
        for(int i=1;i<m;++i) {
            if(text2[i] == text1[0])
                count[0][i] = 1;
            else
                count[0][i] = count[0][i-1];
        }
        
        for(int i=1;i<n;++i) {
            for(int j=1;j<m;++j) {
                if(text1[i] == text2[j])
                    count[i][j] = count[i-1][j-1] + 1;
                else
                    count[i][j] = max(count[i-1][j], count[i][j-1]);
            }
        }
    
        return count[n-1][m-1];
    }
};
