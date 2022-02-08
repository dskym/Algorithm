class Solution {
public:
    int minSetSize(vector<int>& arr) {
        int c = arr.size();
        int base = c / 2;
        vector<int> count(100001, 0);
        for(int t : arr) {
            count[t]++;
        }
        sort(count.begin(), count.end(), greater<int>());
        int ret = 0;
        for(int i=0;i<count.size();++i) {
            ret++;
            c -= count[i];
            
            if(c <= base)
                return ret;
        }
        return 0;
    }
};
