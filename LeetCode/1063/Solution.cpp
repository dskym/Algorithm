class Solution {
public:
    int validSubarrays(vector<int>& nums) {
        int ret = 0;
        for(int i=0;i<nums.size();++i) {
            for(int j=i;j<nums.size();++j) {
                if(nums[i] <= nums[j]) {
                    ret++;
                } else {
                    break;
                }
            }
        }
        return ret;
    }
};
