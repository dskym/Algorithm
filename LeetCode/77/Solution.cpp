class Solution {
public:
    vector<vector<int>> ret;
    void solve(int start, int end, int k, vector<int>& temp) {
        if(temp.size() == k) {
            ret.push_back(temp);
        }

        for(int i=start;i<=end;++i) {
            temp.push_back(i);
            solve(i+1, end, k, temp);
            temp.pop_back();
        }
    }
    vector<vector<int>> combine(int n, int k) {
        vector<int> t;
        solve(1, n, k, t);
        return ret;        
    }
};
