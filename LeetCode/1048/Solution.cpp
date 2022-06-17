class Solution {
public:
    bool static compare(string a, string b){
        return a.size() < b.size();
    }
    
    int longestStrChain(vector<string>& words) {
        sort(words.begin(), words.end(), compare);

        map<string, int> m;
        int result = 1;

        for(string word : words) {
            m[word] = 1;
            for(int i=0;i<word.size();++i) {
                string temp = word.substr(0, i) + word.substr(i+1, word.length()+1);
                if(m.find(temp) != m.end()) {
                    m[word] = max(m[word], m[temp] + 1);
                }
            }
            result = max(result, m[word]);
        }
        return result;
    }
};
