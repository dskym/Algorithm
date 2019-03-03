#include <stack>
#include <string>

class Solution {
public:
    string decodeString(string s) {
        stack<string> sta;
        string result = "";
        string digit = "";
        
        for(int i=0;i<s.length();++i) {
            if(s[i] == ']') {
                string temp;
                
                while(1) {
                    string t = sta.top();
                    sta.pop();
                    
                    if(!t.compare("["))
                        break;
                    else
                        temp = t + temp;
                }
                
                int num = stoi(sta.top());
                sta.pop();
                
                for(int j=0;j<num;++j) {
                    sta.push(temp);
                }
            } else if(s[i] == '[') {
                sta.push(digit);
                digit = "";
                sta.push("[");
            } else if(s[i] >= '0' && s[i] <= '9') {
                digit += s[i];
            } else {
                string a = "";
                a += s[i];
                sta.push(a);
            }
        }
        
        while(!sta.empty()) {            
            string t = sta.top();
            sta.pop();
            
            result = t + result;
        }
        
        return result;
    }
};
