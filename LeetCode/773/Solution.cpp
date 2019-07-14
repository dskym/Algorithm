class Solution {
public:
    int slidingPuzzle(vector<vector<int>>& board) {
        /*
        1    10    100
        1000 10000 100000
        */
        int base[2][3] = {{1, 10, 100}, {1000, 10000, 100000}};
        int direct[2][4] = {{0, 0, 1, -1}, {1, -1, 0, 0}};
        
        int dest = 1 + 20 + 300 + 4000 + 50000;
        
        bool visited[1000000];
        
        for(int i=0;i<1000000;++i)
            visited[i] = false;
        
        int count = 0;

        int status = 0;
        
        int cx = 0;
        int cy = 0;
        
        for(int i=0;i<2;++i) {
            for(int j=0;j<3;++j) {
                if(board[i][j] == 0) {
                    cx = i;
                    cy = j;
                }
            }
        }
        
        for(int i=0;i<2;++i)
            for(int j=0;j<3;++j)
                status += base[i][j] * board[i][j];
            
        //status, count
        queue<pair<vector<vector<int>>, int>> q;
        
        q.push({board, 0});
        visited[status] = true;
        
        while(!q.empty()) {
            auto node = q.front();
            q.pop();
            
            vector<vector<int>> curr = node.first;
            int c = node.second;

            for(int i=0;i<2;++i) {
                for(int j=0;j<3;++j) {
                    if(curr[i][j] == 0) {
                        cx = i;
                        cy = j;
                    }
                }
            }
                        
            int currStatus = 0;
            
            for(int i=0;i<2;++i)
                for(int j=0;j<3;++j)
                    currStatus += base[i][j] * curr[i][j];
                        
            if(dest == currStatus)
                return c;
            
            for(int i=0;i<4;++i) {
                int dx = cx + direct[0][i];
                int dy = cy + direct[1][i];
                
                if(dx >= 0 && dx < 2 && dy >= 0 && dy < 3) {
                    int temp = curr[cx][cy];
                    curr[cx][cy] = curr[dx][dy];
                    curr[dx][dy] = temp;

                    int tempStatus = 0;
                    
                    for(int i=0;i<2;++i)
                        for(int j=0;j<3;++j)
                            tempStatus += base[i][j] * curr[i][j];

                    if(visited[tempStatus] == false) {
                        q.push({curr, c+1});
                        visited[tempStatus] = true;
                    }
                    
                    temp = curr[cx][cy];
                    curr[cx][cy] = curr[dx][dy];
                    curr[dx][dy] = temp;
                }
            }
                    
        }
        
        return -1;
    }
};

