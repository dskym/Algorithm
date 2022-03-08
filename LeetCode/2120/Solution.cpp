class Solution {
public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {        
        vector<int> ret;
        for(int i=0;i<s.size();++i) {
            int x = startPos[0];
            int y = startPos[1];
            int temp = 0;
            for(int j=i;j<s.size();++j) {
                if(s[j] == 'U') {
                    x--;
                    if(x < 0)
                        break;
                } else if(s[j] == 'D') {
                    x++;
                    if(x >= n)
                        break;
                } else if(s[j] == 'L') {
                    y--;
                    if(y < 0)
                        break;
                } else if(s[j] == 'R') {
                    y++;
                    if(y >= n)
                        break;
                }
                temp++;
            }            
            ret.push_back(temp);
        }
        return ret;
    }
};
