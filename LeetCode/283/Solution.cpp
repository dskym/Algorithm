class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        int index = 0;
        
        for(int i=0;i<n;++i) {
            for(int j=index;j<i;++j) {
                if(nums[j] == 0 && nums[i] != 0) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    
                    index++;
                }
            }
        }
    }
};
