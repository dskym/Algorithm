class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        int n = mat.size();
        int m = mat[0].size();
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                for(int k=0;k<n;++k) {
                    if(n-i+k >= n || k+1 >= m)
                        continue;
                    
                    if(mat[n-1-i+k][k] > mat[n-i+k][k+1]) {
                        int temp = mat[n-1-i+k][k];
                        mat[n-1-i+k][k] = mat[n-i+k][k+1];
                        mat[n-i+k][k+1] = temp;
                    }
                }
            }
        }
        
        for(int i=1;i<m;++i) {
            for(int j=0;j<n;++j) {
                for(int k=0;k<n;++k) {
                    if(i+k+1 >= m || k+1 >= n)
                        continue;
                    
                    if(mat[k][i+k] > mat[k+1][i+k+1]) {
                        int temp = mat[k][i+k];
                        mat[k][i+k] = mat[k+1][i+k+1];
                        mat[k+1][i+k+1] = temp;
                    }
                }
            }
        }
        
        return mat;
    }
};
