class Solution {
public:
    int stringToInt(string s) {        
        return atoi(s.c_str());        
    }
    
    int scoreOfParentheses(string S) {
        stack<string> s;
        
        for(int i=0;i<S.size();++i) {
            if(S[i] == '(') {
                s.push("(");
            } else if(S[i] == ')') {
                int temp = 0;
                bool flag = false;
                
                while(true) {
                    string top = s.top();
                    s.pop();
                    
                    if(top == "(") {
                        if(flag)
                            s.push(to_string(temp * 2));
                        else
                            s.push(to_string(1));
                        
                        break;
                    } else {
                        flag = true;
                        temp += stringToInt(top);                        
                    }
                }
            }
        }
        
        int result = 0;
        
        while(!s.empty()) {
            result += stringToInt(s.top());
            s.pop();
        }
        
        return result;
    }
};
