class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int count = 0;
        int result = 0;
        
        for(int num : nums) {
            if(num)
                count++;
            else {
                result = max(result, count);
                count = 0;
            }
        }
        
        result = max(result, count);
        
        return result;
    }
};
