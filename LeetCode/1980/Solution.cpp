class Solution {
public:
    string findDifferentBinaryString(vector<string>& nums) {
        int n = nums.size();
        vector<int> temp;        
        int base = 0;
        
        for(int i=0;i<n;++i) {
            int t = 0;
            int b = 1;
            for(int j=n-1;j>=0;--j) {
                t += (nums[i][j] - '0') * b;
                b *= 2;
            }
            temp.push_back(t);
        }
        
        sort(temp.begin(), temp.end());
        
        for(int i=0;i<n;++i) {
            if(base != temp[i]) {
                break;
            }
            base++;
        }
        
        string ret = "";
        
        while(base) {
            ret = (base % 2 ? "1" : "0") + ret;
            base /= 2;
        }
        
        for(int i=ret.size();i<n;++i) {
            ret = "0" + ret;
        }
        
        return ret;
    }
};
