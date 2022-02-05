class Solution {
public:
    int numberOfBeams(vector<string>& bank) {
        int ret = 0;
        int prev = 0;
        for(string s : bank) {
            int cnt=0;
            for(char c : s) {
                if(c == '1')
                    cnt++;
            }
            if(cnt == 0)
                continue;
            ret += prev * cnt;
            prev = cnt;
        }
        return ret;
    }
};
