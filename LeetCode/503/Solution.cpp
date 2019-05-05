class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        int n = nums.size();
        
        vector<int> result;
        
        for(int i=0;i<n;++i) {
            int idx = i + 1;
            bool flag = true;
            
            while(idx % n != i) {
                if(nums[idx % n] > nums[i]) {
                    result.push_back(nums[idx % n]);
                    flag = false;
                    break;
                }
                
                idx++;
            }
            
            if(flag)
                result.push_back(-1);
        }
        
        return result;
    }
};
