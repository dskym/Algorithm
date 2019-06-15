class Solution {
public:
    int peakIndexInMountainArray(vector<int>& A) {
        int index = -1;
        
        for(int i=1;i<A.size()-1;++i) {
            if(A[i-1] < A[i] && A[i] > A[i+1]) {
                index = i;
                break;
            }
        }
        
        return index;
    }
};
