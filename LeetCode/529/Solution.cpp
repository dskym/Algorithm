class Solution {
public:
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        vector<vector<char>> map;
        bool visited[51][51];
        
        int direct[8][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
                
        for(int i=0;i<51;++i)
            for(int j=0;j<51;++j)
                visited[i][j] = false;
        
        int row = board.size();
        int col = board[0].size();
        
        
        for(int i=0;i<row;++i) {
            vector<char> temp;
            for(int j=0;j<col;++j) {
                temp.push_back(board[i][j]);
            }
            map.push_back(temp);
        }

        int x = click[0];
        int y = click[1];
        
        if(board[x][y] == 'M') {            
            map[x][y] = 'X';
        } else {
            queue<pair<int, int>> q;
            
            q.push({x, y});
            visited[x][y] = true;
            
            while(!q.empty()) {
                auto top = q.front();
                q.pop();
                
                int cx = top.first;
                int cy = top.second;
                
                bool flag = true;
                int count = 0;

                for(int i=0;i<8;++i) {
                    int dx = cx + direct[i][0];
                    int dy = cy + direct[i][1];
                    
                    if(dx >= 0 && dx < row && dy >= 0 && dy < col && board[dx][dy] == 'M') {
                        flag = false;
                        count++;
                    }
                }
                
                if(flag) {
                    map[cx][cy] = 'B';
                    
                    for(int i=0;i<8;++i) {
                        int dx = cx + direct[i][0];
                        int dy = cy + direct[i][1];
                        
                        if(dx >= 0 && dx < row && dy >= 0 && dy < col && !visited[dx][dy]) {
                            visited[dx][dy] = true;
                            q.push({dx, dy});
                        }
                    }
                } else {
                    map[cx][cy] = '0' + count;
                }
            }
        }
        
        return map;
    }
};
