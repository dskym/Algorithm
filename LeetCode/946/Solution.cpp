#include <stack>

class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> s;
        
        int index = 0;
        
        for(int i=0;i<pushed.size();++i) {
            if(pushed[i] == popped[index]) {
                index++;
                
                //check
                while(true) {
                    if(s.empty())
                        break;
                    
                    int t = s.top();
                    
                    if(t == popped[index]) {
                        index++;
                        s.pop();
                    } else {
                        break;
                    }
                }
            } else {
                s.push(pushed[i]);
            }
        }
        
        while(!s.empty()) {
            int t = s.top();
            
            if(t == popped[index]) {
                s.pop();
                index++;
            }
            else
                return false;
        }
        
        return true;
    }
};
