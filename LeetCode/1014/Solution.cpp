class Solution {
public:
    int maxScoreSightseeingPair(vector<int>& A) {
        int ret = 0;
        int temp = A[0] + 0;
        
        for(int i=1;i<A.size();++i) {
            ret = max(ret, temp + A[i] - i);
            temp = max(temp, A[i] + i);
        }
        
        return ret;
    }
};

