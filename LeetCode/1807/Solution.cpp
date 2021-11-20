class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        map<string, string> m;
        for(vector<string> v : knowledge) {
            m[v[0]] = v[1];
        }
        
        string ret;
        
        for(int i=0;i<s.size();++i) {
            if(s[i] == '(') {
                string temp = "";
                while(s[++i] != ')') {
                    temp += s[i];                    
                }
                if(m.find(temp) == m.end()) {
                    ret += "?";
                } else
                    ret += m[temp];
            } else
                ret += s[i];
        }
        
        return ret;
    }
};
