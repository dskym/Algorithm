class Solution {
public:
    int minPairSum(vector<int>& nums) {
        int ret = 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for(int i=0;i<n/2;++i) {
            if(ret < nums[i] + nums[n-i-1])
                ret = nums[i] + nums[n-i-1];
        }
        return ret;
    }
};
