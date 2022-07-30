class Solution {
public:
    bool compa(string a, string b) {
        int idx1 = 0, idx2 = 0;
        while(a.size() > idx1 && b.size() > idx2) {
            if(a[idx1] == b[idx2]) {
                idx1++;
                idx2++;
            } else {
                idx1++;
            }
        }
        return idx2 == b.size();
    }
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        vector<string> ret;
        vector<int> count(26, 0);
        
        for(string word : words2) {
            vector<int> temp(26, 0);
            for(char c : word) {
                temp[c-'a']++;
            }
            for(int i=0;i<26;++i) {
                count[i] = max(count[i], temp[i]);
            }
        }
        
        string comp = "";
        for(int i=0;i<26;++i) {
            for(int j=0;j<count[i];++j) {
                comp += 'a'+i;
            }
        }
        
        vector<string> temp;
        for(string& word : words1) {
            string t = word;
            sort(t.begin(), t.end());
            temp.push_back(t);
        }

        for(int i=0;i<words1.size();++i) {
            if(compa(temp[i], comp)) {
                ret.push_back(words1[i]);
            }
        }
        
        return ret;
    }
};
