class Solution {
public:
    vector<int> xorQueries(vector<int>& arr, vector<vector<int>>& queries) {
        vector<int> dp;

        int temp = arr[0];
        dp.push_back(temp);
        
        for(int i=1;i<arr.size();++i) {
            temp ^= arr[i];
            dp.push_back(temp);
        }
        
        vector<int> ret;
        
        for(auto query : queries) {
            if(query[0] == query[1]) {
                ret.push_back(arr[query[0]]);
            } else {
                if(query[0] == 0) {
                    ret.push_back(dp[query[1]]);
                } else {
                    ret.push_back(dp[query[1]] ^ dp[query[0]-1]);
                }
            }
        }
        
        return ret;
    }
};
