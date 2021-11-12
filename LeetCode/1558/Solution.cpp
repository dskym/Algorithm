class Solution {
public:
    int minOperations(vector<int>& nums) {
        int ret = 0;
        
        while(true) {
            bool exit = true;
            for(int i=0;i<nums.size();++i)
                if(nums[i] != 0)
                    exit = false;
            
            if(exit)
                break;

            bool flag = true;
            for(int i=0;i<nums.size();++i) {
                if(nums[i] % 2 == 1) {
                    nums[i]--;
                    ret++;
                    flag = false;
                }
            }
            if(flag) {
                for(int i=0;i<nums.size();++i) {
                    nums[i] /= 2;
                }
                ret++;
            }
        }
        
        return ret;
    }
};
