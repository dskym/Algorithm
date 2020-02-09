class Solution {
public:
    int titleToNumber(string s) {
        map<char, int> m;
        
        for(int i=0;i<26;++i)
            m['A'+i] = i+1;
        
        long long int ret = 0;
        long long int base = 1;
        
        for(int i=s.size()-1;i>=0;--i) {
            ret += base * m[s[i]];
            base *= 26;
        }
        
        return ret;
    }
};

