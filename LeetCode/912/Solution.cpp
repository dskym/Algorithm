class Solution {
public:
    vector<int> sortArray(vector<int>& nums) {
        int count[100001];
        
        for(int i=0;i<100001;++i)
            count[i] = 0;
        
        for(int i=0;i<nums.size();++i)
            count[nums[i]+50000]++;
        
        vector<int> ret;
        
        for(int i=0;i<=100000;++i) {
            if(count[i] == 0)
                continue;
            
            while(count[i]--)
                ret.push_back(i-50000);
        }

        return ret;
    }
};
