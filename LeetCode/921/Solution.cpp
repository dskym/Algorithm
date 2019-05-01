class Solution {
public:
    int minAddToMakeValid(string S) {
        stack<char> s;
        int count = 0;
        
        for(int i=0;i<S.length();++i) {
            if(S[i] == '(')
                s.push('(');
            else {
                if(s.empty())
                    count++;
                else if(s.top() == '(')
                    s.pop();
            }
        }
        
        count += s.size();
        
        return count;
    }
};
