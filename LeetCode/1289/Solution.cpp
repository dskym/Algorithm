class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& grid) {
        int arr[201][201];
        
        for(int i=0;i<201;++i)
            for(int j=0;j<201;++j)
                arr[i][j] = 0;
        
        int n = grid.size();
        
        for(int i=0;i<n;++i) {
            arr[n-1][i] = grid[n-1][i];
        }
        
        for(int i=n-2;i>=0;--i) {
            for(int j=0;j<n;++j) {
                int temp = 1000000;
                for(int k=0;k<n;++k) {
                    if(j == k)
                        continue;
                    if(temp > arr[i+1][k] + grid[i][j])
                        temp = arr[i+1][k] + grid[i][j];
                }
                arr[i][j] = temp;
            }
        }
        
        int ret = 1000000;
        for(int i=0;i<n;++i) {
            if(ret > arr[0][i])
                ret = arr[0][i];
        }
        return ret;
    }
};
