class Solution {
public:
    vector<int> diStringMatch(string S) {
        vector<int> result;
        
        int s = 0, m = S.length();
        
        for(int i=0;i<=S.length();++i) {
            if(S[i] == 'I')
                result.push_back(s++);
            else
                result.push_back(m--);
        }
        
        return result;
    }
};
