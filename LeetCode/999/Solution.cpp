class Solution {
public:
    int numRookCaptures(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();
        
        int result = 0;
        
        int x, y;
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        
        for(int i=x-1;i>=0;--i) {
            if(board[i][y] == 'p') {
                result++;
                break;
            } else if(board[i][y] == 'B') {
                break;
            }
        }

        for(int i=x+1;i<n;++i) {
            if(board[i][y] == 'p') {
                result++;
                break;
            } else if(board[i][y] == 'B') {
                break;
            }
        }

        for(int i=y-1;i>=0;--i) {
            if(board[x][i] == 'p') {
                result++;
                break;
            } else if(board[x][i] == 'B') {
                break;
            }
        }
        
        for(int i=y+1;i<m;++i) {
            if(board[x][i] == 'p') {
                result++;
                break;
            } else if(board[x][i] == 'B') {
                break;
            }
        }
        
        return result;
    }
};
