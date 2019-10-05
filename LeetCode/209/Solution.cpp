
class Solution {
public:
    int minSubArrayLen(int s, vector<int>& nums) {
        int answer = 0;
        
        int left = 0;
        int right = nums.size();

        while(left <= right) {
            int mid = (left + right) / 2;

            int result = 0;

            for(int i=0;i<mid;++i)
                result += nums[i];
            
            bool flag = false;

            for(int i=mid;i<=nums.size();++i) {
                if(result >= s) {
                    answer = mid;
                    right = mid - 1;
                    flag = true;
                    break;
                }
                
                if(i != nums.size()) {
                    result += nums[i];
                    result -= nums[i-mid];
                }
            }
            
            if(!flag)
                left = mid + 1;
        }

        return answer;
    }
};
