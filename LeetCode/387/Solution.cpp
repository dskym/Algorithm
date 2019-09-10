class Solution {
public:
    const int MAX = 1000000000;
    
    int firstUniqChar(string s) {
        bool arr[26];
        bool flag[26];
        int result[26];
        
        for(int i=0;i<26;++i) {
            arr[i] = false;
            flag[i] = false;
            result[i] = MAX;
        }
        
        for(int i=0;i<s.length();++i) {
            int index = s[i]-'a';
            
            if(arr[index] == false && flag[index] == false) {
                arr[index] = true;
                flag[index] = true;
                result[index] = i;
            } else if(arr[index] == true && flag[index] == true) {
                arr[index] = false;
                result[index] = MAX;
            }
        }
        
        int ret = MAX;
        
        for(int i=0;i<26;++i) {
            if(arr[i])
                ret = min(ret, result[i]);
        }
        
        if(ret == MAX)
            ret = -1;
        
        return ret;
    }
};
