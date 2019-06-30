class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();
        
        for(int i=n-2;i>=0;--i) {
            vector<int> temp = matrix[i+1];
            
            for(int j=0;j<m-1;++j) {
                if(temp[j+1] != matrix[i][j])
                    return false;
            }
        }        
        
        return true;
    }
};
