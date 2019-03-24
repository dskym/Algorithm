class Solution {
public:
    int thirdMax(vector<int>& nums) {
        int n = nums.size();
        int temp = nums[0];
        int min_temp = nums[0];
        
        set<int> s;
        
        for(int j=1;j<n;++j) {
            temp = max(temp, nums[j]);
            min_temp = min(min_temp, nums[j]);
        }          

        int r = temp;
        s.insert(temp);
        
        for(int i=0;i<2;++i) {            
            int t = min_temp;

            for(int j=0;j<n;++j) {
                if(t < nums[j] && temp > nums[j]) {
                    t = nums[j];
                }
            }
            
            temp = t;
            
            s.insert(temp);
        }
        
        if(s.size() >= 3)
            return temp;
        else
            return r;
    }
        
};
