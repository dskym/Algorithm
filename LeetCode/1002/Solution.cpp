class Solution {
public:
    vector<string> commonChars(vector<string>& A) {
        vector<int> result(26, 200);
        
        for(string s : A) {
            vector<int> count(26, 0);
            
            for(char c : s)
                count[c - 'a']++;
            
            for(int i=0;i<26;++i)
                result[i] = min(result[i], count[i]);
        }
        
        vector<string> r;
        
        for(int i=0;i<26;++i) {
            if(result[i] != 0) {
                for(int j=0;j<result[i];++j) {
                    char temp = i + 'a';
                    r.push_back(string(1, temp));
                }
            }
        }
        
        return r;
    }
};
