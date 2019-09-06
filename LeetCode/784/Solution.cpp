class Solution {
public:
    vector<string> ret;

    void makeString(string S, int index, string make) {
        if(S.length() == index) {
            ret.push_back(make);
            
            return;
        }

        if(S[index] >= 'a' && S[index] <= 'z')
            makeString(S, index+1, make + string(1, (S[index] - 'a') + 'A'));

        if(S[index] >= 'A' && S[index] <= 'Z')
            makeString(S, index+1, make + string(1, (S[index] - 'A') + 'a'));
        
        makeString(S, index+1, make + S[index]);
    }
    
    vector<string> letterCasePermutation(string S) {
        makeString(S, 0, "");
        
        return ret;
    }
};
