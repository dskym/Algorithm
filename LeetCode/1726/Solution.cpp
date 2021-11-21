class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        int ret = 0;
        map<int, int> m;
        sort(nums.begin(),nums.end());
        for(int a=0;a<nums.size();++a) {
            for(int b=a+1;b<nums.size();++b) {
                m[nums[a] * nums[b]]++;
            }            
        }
        
        for(auto it = m.begin();it !=m.end();++it) {
            if(it->second > 1) {
                ret += it->second * (it->second-1) / 2 * 8;
            }
        }
        return ret;
    }
};
