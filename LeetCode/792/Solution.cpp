class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        map<char, vector<string>> m;
        
        for(string word : words) {
            if(m.find(word[0]) != m.end())
                m[word[0]].push_back(word);
            else
                m[word[0]]={word};
        }
        
        for(int i=0;i<s.size();++i) {
            vector<string> temp = m[s[i]];
            vector<string> temp2;
            for(string t : temp) {
                if(t.size()>1) {
                    if(m.find(t[1]) != m.end()) {
                        if(t[1] == s[i]) {
                            temp2.push_back(t.substr(1));
                        } else {
                            m[t[1]].push_back(t.substr(1));
                        }
                    } else {
                        m[t[1]] = {t.substr(1)};
                    }
                }
            }
            m[s[i]] = temp2;
        }
        
        int ret = words.size();
        for(auto it=m.begin();it!=m.end();++it) {
            ret -= (it->second).size();
        }
        return ret;
    }
};
