class Solution {
public:
    void solve(vector<string> &ret, string &digits, map<char, vector<char>> &m, int index, string s) {
        if(digits.size() == index) {
            ret.push_back(s);
            return;
        }
        
        for(int i=0;i<m[digits[index]].size();++i) {
            solve(ret, digits, m, index+1, s+m[digits[index]][i]);
        }
    }
    vector<string> letterCombinations(string digits) {
        if(digits.size() == 0)
            return {};
        
        map<char, vector<char>> m;
        m['2'] = vector<char>{'a', 'b', 'c'};
        m['3'] = vector<char>{'d', 'e', 'f'};
        m['4'] = vector<char>{'g', 'h', 'i'};
        m['5'] = vector<char>{'j', 'k', 'l'};
        m['6'] = vector<char>{'m', 'n', 'o'};
        m['7'] = vector<char>{'p', 'q', 'r', 's'};
        m['8'] = vector<char>{'t', 'u', 'v'};
        m['9'] = vector<char>{'w', 'x', 'y', 'z'};
        
        vector<string> ret;
        solve(ret, digits, m, 0, "");
        return ret;
    }
};
