class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        int size = A.size();
        
        vector<int> v(size, 0);
        
        int odd = 1;
        int even = 0;
        
        for(int i=0;i<size;++i) {
            if(A[i] % 2 == 0) {
                v[even] = A[i];
                even += 2;
            } else {
                v[odd] = A[i];
                odd += 2;
            }
        }
        
        return v;
    }
};
