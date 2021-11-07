class Solution {
public:
    char findKthBit(int n, int k) {
        string s = "0";
        
        for(int i=0;i<n-1;++i) {
            string temp = "";
            for(int j=s.size()-1;j>=0;--j) {
                if(s[j] == '1')
                    temp += '0';
                else
                    temp += '1';
            }
            s = s + "1" + temp;
        }
        return s[k-1];
    }
};
