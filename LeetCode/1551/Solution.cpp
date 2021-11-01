class Solution {
public:
    int minOperations(int n) {
        int ret = 0;
        for(int i=1;i<n;i+=2) {
            ret += (n - i);
        }
        return ret;
    }
};
