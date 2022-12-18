class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<long long int> s;
        for(string token : tokens) {
            if(token == "+") {
                long long int a = s.top();
                s.pop();
                long long int b = s.top();
                s.pop();
                s.push(a+b);
            } else if(token == "*") {
                long long int a = s.top();
                s.pop();
                long long int b = s.top();
                s.pop();
                s.push(a*b);
            } else if(token == "/") {
                long long int a = s.top();
                s.pop();
                long long int b = s.top();
                s.pop();
                s.push(b/a);
            } else if(token == "-") {
                long long int a = s.top();
                s.pop();
                long long int b = s.top();
                s.pop();
                s.push(b-a);
            } else {
                s.push(stoi(token));
            }
        }
        return s.top();
    }
};
