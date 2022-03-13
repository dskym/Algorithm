class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector<int> ret(nums.size());
        int pos=0, neg=1;
        for(int num : nums) {
            if(num > 0) {
                ret[pos] = num;
                pos += 2;
            } else {
                ret[neg] = num;
                neg += 2;
            }
        }
        return ret;
    }
};
