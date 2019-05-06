class Solution {
public:
    bool isMonotonic(vector<int>& A) {
        bool flag = true;
        bool compare = true;
                
        for(int i=0;i<A.size() - 1;++i) {
            if(A[i] > A[i+1]) {
                compare = false;
                break;
            } else if(A[i] < A[i+1]) {
                compare = true;
                break;
            }
        }
        
        for(int i=1;i<A.size();++i) {
            if(A[i-1] > A[i] && compare) {
                flag = false;
                break;
            } else if(A[i - 1] < A[i] && !compare) {
                flag = false;
                break;
            }
        }

        return flag;
    }
};
