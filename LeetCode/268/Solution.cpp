class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        
        int result = 0;
        
        for(int num : nums)
            result += num;
        
        return n * (n + 1) / 2 - result;
    }
};
