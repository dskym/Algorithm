class Solution {
public:
    vector<int> diStringMatch(string S) {
        vector<int> result;
        
        result.push_back(0);
        
        for(int i=S.length()-1;i>=0;--i) {
            if(S[i] == 'I') {                
                for(int j=0;j<result.size();++j)
                    result[j] += 1;
                
                result.insert(result.begin(), 0);
            }
            else {
                result.insert(result.begin(), result.size());
            }
        }
        
        return result;
    }
};
