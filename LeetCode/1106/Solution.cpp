class Solution {
public:
    bool parseBoolExpr(string expression) {
        stack<char> s;
        
        for(int i=0;i<expression.size();++i) {
            if(expression[i] == '|' || expression[i] == '&' || expression[i] == 'f' || expression[i] == 't' || expression[i] == '(' || expression[i] == '!')
                s.push(expression[i]);
            else if(expression[i] == ')') {
                vector<char> v;
                
                while(s.top() != '(') {
                    v.push_back(s.top());
                    s.pop();
                }
                
                s.pop();
                
                char op = s.top();
                s.pop();
                
                char temp = v[0];
                
                if(op == '!') {
                    if(temp == 't')
                        temp = 'f';
                    else
                        temp = 't';
                } else {
                    for(int j=1;j<v.size();++j) {
                        if(op == '&') {
                            if(temp == 'f' || v[j] == 'f') {
                                temp = 'f';
                                break;
                            } else {
                                temp = 't';
                            }
                        } else if(op == '|') {
                            if(temp == 't' || v[j] == 't') {
                                temp = 't';
                                break;
                            } else {
                                temp = 'f';
                            }
                        }
                    }                    
                }
                
                s.push(temp);
            }
        }
        
        if(s.top() == 't')
            return true;
        else
            return false;
    }
};
