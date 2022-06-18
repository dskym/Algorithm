class Solution {
public:
    int minKnightMoves(int x, int y) {
        bool visited[601][601];
        
        for(int i=0;i<601;++i)
            for(int j=0;j<601;++j)
                visited[i][j] = false;
        
        int position[8][2] = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, -2}, {-1, 2}, {-2, 1}, {-2, -1}};
        
        queue<pair<pair<int, int>,int>> q;
        q.push({{300, 300}, 0});
        visited[300][300] = true;
        
        while(!q.empty()) {
            auto t = q.front();
            q.pop();
            
            int xx = t.first.first;
            int yy = t.first.second;
            int c = t.second;
            
            if(xx == x+300 && yy == y+300)
                return c;
            
            for(int i=0;i<8;++i) {
                int dx = xx + position[i][0];
                int dy = yy + position[i][1];
                
                if(dx >= 0 && dy >= 0 && dx <= 600 && dy <= 600 && visited[dx][dy] == false) {
                    q.push({{dx, dy}, c+1});
                    visited[dx][dy] = true;
                }
            }
        }
        return 0;
    }
};
