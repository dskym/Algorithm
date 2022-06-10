class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        vector<int> result;
        int left = 0, right = numbers.size()-1;
        
        while(left < right) {
            int temp = numbers[left] + numbers[right];
            if(temp == target) {
                return {left+1, right+1};
            } else if(temp > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
   }
};
