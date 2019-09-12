class Solution {
public:
    int majorityElement(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        
        int limit = nums.size() / 2;
        int count = 0;
        int temp = nums[0];
        
        for(int i=1;i<nums.size();++i) {
            if(temp != nums[i]) {
                temp = nums[i];
                count = 0;
            } else
                count++;
            
            if(count >= limit)
                return temp;
        }
        
        return temp;
    }
};
