class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
         if(s.size()<p.size())
            return {};

        vector<int> cnt(26, 0);
        for(int i=0;i<p.size();++i) {
            cnt[p[i]-'a']++;
        }
               
        vector<int> temp(26, 0);
        for(int j=0;j<p.size();++j) {
            temp[s[j]-'a']++;
        }
        
        vector<int> ret;
        for(int i=0;i<s.size()-p.size()+1;++i) {
            bool flag = true;
            for(int j=0;j<26;++j) {
                if(cnt[j] != temp[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ret.push_back(i);
            
            if(i != s.size()-p.size()) {
                temp[s[i]-'a']--;
                temp[s[p.size()+i]-'a']++;
            }
        }
        
        return ret;
    }
};
