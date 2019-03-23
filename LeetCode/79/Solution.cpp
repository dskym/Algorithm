class Solution {
public:    
    bool** visited;
    
    bool solve(vector<vector<char>>& board, int x, int y, string s) {
        //cout << x << " " << y << endl;
        if(s == "")
            return true;
        
        int n = board.size();
        int m = board[0].size();
        
        if(x < n-1 && s[0] == board[x+1][y] && visited[x+1][y] == false) {
            visited[x+1][y] = true;
            
            if(solve(board, x+1, y, s.substr(1)) == true)
                return true;
            
            visited[x+1][y] = false;            
        }
        
        if(x > 0 && s[0] == board[x-1][y] && visited[x-1][y] == false) {
            visited[x-1][y] = true;

            if(solve(board, x-1, y, s.substr(1)) == true)
                return true;

            visited[x-1][y] = false;
        }
        
        if(y < m-1 && s[0] == board[x][y+1] && visited[x][y+1] == false) {
            visited[x][y+1] = true;

            if(solve(board, x, y+1, s.substr(1)) == true)
                return true;
            
            visited[x][y+1] = false;
        }

        if(y > 0 && s[0] == board[x][y-1] && visited[x][y-1] == false) {
            visited[x][y-1] = true;

            if(solve(board, x, y-1, s.substr(1)) == true)
                return true;
            
            visited[x][y-1] = false;
        }
        
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        int n = board.size();
        int m = board[0].size();
        
        visited = new bool*[n];
        
        for(int i=0;i<n;++i) {
            visited[i] = new bool[m];
            
            for(int j=0;j<m;++j)
                visited[i][j] = false;
        }
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(board[i][j] == word[0]) {
                    visited[i][j] = true;
                    
                    if(solve(board, i, j, word.substr(1)) == true)
                        return true;
                    
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }
    
};
