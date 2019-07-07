class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        bool visited[51][51];
        
        int n = image.size();
        int m = image[0].size();
        
        for(int i=0;i<n;++i)
            for(int j=0;j<m;++j)
                visited[i][j] = false;
        
        int direct[2][4] = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        queue<pair<int, int>> q;
        
        q.push({sr, sc});
        
        int temp = image[sr][sc];
        visited[sr][sc] = true;
        
        while(!q.empty()) {
            auto top = q.front();
            q.pop();
            
            image[top.first][top.second] = newColor;
        
            for(int i=0;i<4;++i) {
                int dx = top.first + direct[0][i];
                int dy = top.second + direct[1][i];
                
                if(dx >= 0 && dx < n && dy >= 0 && dy < m && image[dx][dy] == temp && visited[dx][dy] == false) {
                    q.push({dx, dy});
                    visited[dx][dy] = true;
                }
            }
        }        
        
        return image;
    }
};
