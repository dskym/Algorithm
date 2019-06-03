class Solution {
public:
    vector<vector<int>> transpose(vector<vector<int>>& A) {
        int n = A.size();
        int m = A[0].size();
        
        vector<vector<int>> result;
        
        for(int i=0;i<m;++i) {
            vector<int> temp(n, 0);
            result.push_back(temp);
        }
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                result[j][i] = A[i][j];
        
        return result;
    }
};
