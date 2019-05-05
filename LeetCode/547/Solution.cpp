class Solution {
public:
    bool visited[201];

    void dfs(vector<vector<int>>& M, int node) {
        for(int i=0;i<M.size();++i) {
            if(node != i && M[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(M, i);
            }
        }
    }
    
    int findCircleNum(vector<vector<int>>& M) {
        int n = M.size();
        int result = 0;
        
        for(int i=0;i<n;++i)
            visited[i] = false;
                
        for(int i=0;i<n;++i) {
            if(!visited[i]) {
                result++;
                
                visited[i] = true;
                dfs(M, i);
            }
        }
        
        return result;
    }
};
