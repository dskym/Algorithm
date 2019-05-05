class Solution {
public:
    bool isValid(string S) {
        stack<char> s;
        
        for(int i=0;i<S.length();++i) {
            if(S[i] == 'c') {
                if(s.empty())
                    return false;
                
                if(s.top() == 'b') {
                    s.pop();
                    
                    if(s.empty())
                        return false;
                    
                    if(s.top() == 'a') {
                        s.pop();
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
            else
                s.push(S[i]);
        }
        
        if(s.empty())
            return true;
        else
            return false;
    }
};
