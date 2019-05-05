class Solution {
public:
    vector<vector<int>> result;
    
    void solve(vector<int>& candidates, int target, vector<int>& temp, int index) {
        if(target == 0) {
            result.push_back(temp);

            return;
        }
        
        if(target < 0)
            return;
        
        int n = candidates.size();

        for(int i=index;i<n;++i) {
            temp.push_back(candidates[i]);
            solve(candidates, target - candidates[i], temp, i);
            temp.pop_back();
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        int n = candidates.size();
        
        vector<int> temp;
        solve(candidates, target, temp, 0);
        
        return result;
    }
};
