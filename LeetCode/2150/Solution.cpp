class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        vector<int> v(1000001, 0);
        vector<int> ret;        
        
        for(int num : nums) {
            v[num]++;
        }
        
        for(int i=0;i<1000001;++i) {
            if(i == 0 && v[0] == 1 && v[1] == 0) {
                ret.push_back(i);
            } else if(i != 0 && i != 1000000 && v[i] == 1 && v[i-1] == 0 && v[i+1] == 0) {
                ret.push_back(i);
            } else if(i == 1000000 && v[1000000] == 1 && v[999999] == 0) {
                ret.push_back(i);
            }
        }
        
        return ret;
    }
};
