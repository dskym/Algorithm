class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        
        for(int x=0;x<n;++x) {
            for(int y=0;y<x;++y) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
            }
        }
        
        for(int x=0;x<n;++x) {
            for(int y=0;y<n/2;++y) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[x][n-1-y];
                matrix[x][n-1-y] = temp;
            }
        }
    }
};

