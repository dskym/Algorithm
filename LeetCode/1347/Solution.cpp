class Solution {
public:
    int minSteps(string s, string t) {
        int countS[26];
        int countT[26];
       
        for(int i=0;i<26;++i) {
            countS[i] = 0;
            countT[i] = 0;
        }
        
        for(char c : s)
            countS[c-'a']++;

        for(char c : t)
            countT[c-'a']++;
        
        int ret = 0;
        
        for(int i=0;i<26;++i) {
            int temp = countT[i] - countS[i];
            
            ret += (temp > 0) ? temp : 0;
        }
        
        return ret;
    }
};
