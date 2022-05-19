class Solution {
public:
    string reverseParentheses(string s) {
        stack<string> st;
        string temp = "";
        bool reverse = false;
        
        for(int i=0;i<s.size();++i) {
            if(s[i] == '(') {
                reverse = !reverse;
                st.push(temp);
                temp = "";
            } else if(s[i] == ')') {
                string to = st.top();
                st.pop();
                reverse = !reverse;
                if(reverse) {
                    temp = temp + to;
                } else {
                    temp = to + temp;
                }
            } else {
                if(reverse) {
                    temp = s[i] + temp;
                } else {
                    temp += s[i];
                }
            }
        }
        return temp;
    }
};
