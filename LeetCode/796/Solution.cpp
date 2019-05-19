class Solution {
public:    
    bool rotateString(string A, string B) {
        if(A.length() != B.length())
            return false;
        else if(A == "" && B == "")
            return true;
        
        int n = A.length();
        
        for(int i=0;i<n;++i) {
            bool flag = true;

            for(int j=0;j<n;++j) {
                if(A[j] != B[(i + j) % n]) {
                    flag = false;
                    break;
                }
            }
            
            if(flag)
                return true;
        }
        
        return false;
    }
};
