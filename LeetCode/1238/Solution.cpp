class Solution {
public:
    vector<int> base;
    bool visited[1000001];
    bool solve(int n, int start, vector<int>& ret) {
        if(ret.size() == 1 << n) {
            return true;
        }
        for(int i=0;i<n;++i) {
            int test = start ^ base[i];
            if(visited[test] == false) {
                ret.push_back(test);
                visited[test] = true;
                if(solve(n, test, ret)) {
                    return true;
                }
                visited[test] = false;
                ret.pop_back();
            }
        }
        return false;
    }
    vector<int> circularPermutation(int n, int start) {
        int b = 1;
        for(int i=0;i<n;++i) {
            base.push_back(b);
            b *= 2;
        }
        
        vector<int> ret;
        ret.push_back(start);
        visited[start] = true;
        
        solve(n, start, ret);
        return ret;
    }
};
