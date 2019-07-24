class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        int n = A.size();
        int m = A[0].size();
        
        vector<vector<int>> result;
        
        for(int i=0;i<n;++i) {
            vector<int> temp;
            
            for(int j=m-1;j>=0;--j) {
                if(A[i][j] == 1)
                    temp.push_back(0);
                else
                    temp.push_back(1);
            }
            
            result.push_back(temp);
        }
        
        return result;
    }
};

