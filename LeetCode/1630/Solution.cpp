class Solution {
public:
    vector<bool> checkArithmeticSubarrays(vector<int>& nums, vector<int>& l, vector<int>& r) {
        vector<bool> ret;
        for(int i=0;i<l.size();++i) {
            if(r[i] - l[i] == 1) {
                ret.push_back(true);
                continue;
            }
            vector<int> temp = nums;
            sort(temp.begin() + l[i], temp.begin() + r[i] + 1);
            bool flag = true;
            for(int j=l[i];j<r[i]-1;++j) {
                if(temp[j+1] - temp[j] != temp[j+2] - temp[j+1]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                ret.push_back(true);
            else
                ret.push_back(false);
        }
        return ret;
    }
};
