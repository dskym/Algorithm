class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        int n = nums.size();
        int m = nums[0].size();
        
        if(n * m == r * c) {
            vector<vector<int>> ret;
            int count = 0;
            vector<int> t;
            
            for(int i=0;i<n;++i) {
                for(int j=0;j<m;++j) {                    
                    t.push_back(nums[i][j]);
                    count++;
                    
                    if(count == c) {
                        ret.push_back(t);                        
                        t.clear();
                        count = 0;
                    }
                }
            }
            
            return ret;
        } else
            return nums;
    }
};
