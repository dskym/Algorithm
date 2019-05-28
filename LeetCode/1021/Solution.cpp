class Solution {
public:
    string removeOuterParentheses(string S) {
        int count = 0;
        string result = "";
        
        for(int i=0;i<S.length();++i) {
            if(count > 0) {
                result += S[i];
            }
            
            if(S[i] == '(') {                
                count++;
            } else {
                count--;
            }
            
            if(count == 0)
                result.pop_back();
        }
        
        return result;
    }
};
