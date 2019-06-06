class Solution {
public:
    vector<int> sortedSquares(vector<int>& A) {
        int neg = -1;
        int n = A.size();
        
        for(int i=0;i<n;++i) {
            if(A[i] < 0)
                neg = i;
            
            A[i] = A[i] * A[i];
        }
        
        int pos = neg + 1;
        vector<int> result(n, 0);
        int index = 0;
        
        while(neg >= 0 && pos < n) {
            if(A[neg] > A[pos]) {
                result[index++] = A[pos];
                pos++;
            } else {
                result[index++] = A[neg];
                neg--;
            }
        }
            
        while(neg >= 0) {
            result[index++] = A[neg];
            neg--;
        }
        
        while(pos < n) {
            result[index++] = A[pos];
            pos++;
        }

        return result;
    }
};
