class Solution {
public:
    int countCharacters(vector<string>& words, string chars) {
        int ret = 0;
        
        int value[26];
        
        for(int i=0;i<26;++i)
            value[i] = 0;
        
        for(int i=0;i<chars.size();++i)
            value[chars[i]-'a']++;
        
        for(string word : words) {
            int data[26];
            bool flag = true;
            
            for(int i=0;i<26;++i)
                data[i] = 0;
            
            for(int i=0;i<word.size();++i)
                data[word[i]-'a']++;
            
            for(int i=0;i<26;++i) {
                if(data[i] > value[i]) {
                    flag = false;
                    break;                    
                }
            }
            
            if(flag)
                ret += word.size();
        }
        
        return ret;
    }
};
