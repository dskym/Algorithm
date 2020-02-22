class Solution {
public:
    vector<int> pancakeSort(vector<int>& A) {
        int n = A.size();
        int index = -1;
        
        vector<int> ret;
        
        while(n != 0) {
            for(int i=0;i<n;++i) {
                if(A[i] == n) {
                    index = i+1;
                    break;
                }
            }
            
            ret.push_back(index);
            reverse(A.begin(), A.begin() + index);
            ret.push_back(n);
            reverse(A.begin(), A.begin() + n);
            
            n--;
        }
        
        return ret;
    }
};

