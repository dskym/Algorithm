class Solution {
public:
    string removeDuplicates(string S) {
        string result = "";
        
        for(char c : S) {
            if(result == "" || result.back() != c)
                result.push_back(c);
            else
                result.pop_back();
        }
        
        return result;
    }
};
/*
class Solution {
public:
    string removeDuplicates(string S) {
        stack<char> s;
        
        s.push(S[0]);
        
        for(int i=1;i<S.length();++i) {
            if(s.empty()) {
                s.push(S[i]);
                
                continue;
            }
            
            char t = s.top();
            
            if(t == S[i])
                s.pop();
            else
                s.push(S[i]);
        }
        
        string result = "";
        
        while(!s.empty()) {
            char t = s.top();
            s.pop();
            
            result = t + result;
        }
        
        return result;
    }
};
*/
