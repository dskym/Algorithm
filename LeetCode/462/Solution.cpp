class Solution {
public:
    int minMoves2(vector<int>& nums) {
        int result = 0;
        
        sort(nums.begin(), nums.end());
        
        int mid = nums.size() / 2;
        
        for(int num : nums) {
            if(num > nums[mid])
                result += (num - nums[mid]);
            else
                result += (nums[mid] - num);
        }
        
        return result;
    }
};
