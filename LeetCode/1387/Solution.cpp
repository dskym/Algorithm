class Solution {
public:
    int getKth(int lo, int hi, int k) {
        vector<pair<int, int>> v;
        for(int i=lo;i<=hi;++i) {
            int count = 0;
            int temp = i;
            while(temp != 1) {
                if(temp % 2) {
                    temp = temp * 3 + 1;
                } else {
                    temp /= 2;
                }
                count++;
            }
            v.push_back({count, i});            
        }
        sort(v.begin(), v.end());
        return v[k-1].second;
    }
};
