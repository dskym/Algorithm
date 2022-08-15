class Solution {
public:
    int countVowelPermutation(int n) {
        int result[20001][5];
        for(int i=0;i<20001;++i) {
            for(int j=0;j<5;++j) {
                result[i][j] = 0;
            }
        }
        
        for(int j=0;j<5;++j) {
            result[0][j] = 1;
        }
        
        for(int i=1;i<20001;++i) {
            result[i][0] = result[i-1][1];
            result[i][1] = (result[i-1][0] + result[i-1][2]) % 1000000007;
            result[i][2] = (((((result[i-1][0] + result[i-1][1]) % 1000000007) + result[i-1][3]) % 1000000007) + result[i-1][4]) % 1000000007;
            result[i][3] = (result[i-1][2] + result[i-1][4]) % 1000000007;
            result[i][4] = result[i-1][0];
        }

        int r = 0;
        for(int j=0;j<5;++j) {
            r = (r + result[n-1][j]) % 1000000007;
        }
        return r;
    }
};
