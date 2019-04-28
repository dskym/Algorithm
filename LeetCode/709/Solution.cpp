class Solution {
public:
    string toLowerCase(string str) {
        string ret = "";
        int len = str.length();

        for(int i=0;i<len;++i) {
            if(str[i] >= 'A' && str[i] <= 'Z')
                ret += (str[i] - 'A') + 'a';
            else
                ret += str[i];
        }
        
        return ret;
    }
};
