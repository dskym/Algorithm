class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        int retIndex = -1;
        int retDiff = 10000000000;
        
        long long int left = 0;
        long long int right = 0;
        for(int i=0;i<nums.size();++i) {
            right += nums[i];
        }
        
        int temp = 0;
        for(int i=0;i<nums.size();++i) {
            left += nums[i];
            right -= nums[i];
            
            if(i == nums.size()-1) {
                temp = left / (i+1);
            } else {
                temp = left / (i+1) - right / (nums.size()-i-1);
            }
            
            temp = temp > 0 ? temp : -temp;
            if(temp < retDiff) {
                retIndex = i;
                retDiff = temp;
            }
        }
        return retIndex;
    }
};
