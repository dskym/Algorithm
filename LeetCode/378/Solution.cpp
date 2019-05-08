class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        priority_queue<pair<int, pair<int, int>>> pq;
        int n = matrix.size();
        
        bool visited[1001][1001];
        
        for(int i=0;i<n;++i)
            for(int j=0;j<n;++j)
                visited[i][j] = false;
        
        pq.push({matrix[n-1][n-1], {n-1, n-1}});
        visited[n-1][n-1] = true;
        
        k = n * n - k;
        
        while(!pq.empty()) {
            auto value = pq.top();
            pq.pop();
            
            if(k == 0)
                return value.first;
            
            k--;

            auto pos = value.second;
            int x = pos.first;
            int y = pos.second;
            
            if(x - 1 >= 0 && !visited[x-1][y]) {
                pq.push({matrix[x-1][y], {x-1, y}});
                visited[x-1][y] = true;
            }         
            
            if(y - 1 >= 0 && !visited[x][y-1]) {
                pq.push({matrix[x][y-1], {x, y-1}});
                visited[x][y-1] = true;
            }            
        }
        
        return 0;
    }
};
