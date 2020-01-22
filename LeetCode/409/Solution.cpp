class Solution {
public:
    int longestPalindrome(string s) {
        int count[52];
        
        for(int i=0;i<52;++i)
            count[i] = 0;
        
        for(char c : s) {
            if(c >= 'a' && c <= 'z')
                count[c-'a']++;
            else if(c >= 'A' && c <= 'Z')
                count[c-'A'+26]++;
        }
        
        bool flag = false;
        int ret = 0;
        
        for(int i=0;i<52;++i) {
            if(count[i] % 2 == 0)
                ret += count[i];
            else {
                ret += (count[i]-1);
                flag = true;
            }
        }
        
        if(flag)
            ret++;
        
        return ret;
    }
};
