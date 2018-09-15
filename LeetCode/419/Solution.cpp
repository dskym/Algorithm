class Solution {
public:
    int countBattleships(vector<vector<char>>& board) {
        int count = 0;
        
        for(int i=0;i<board.size();++i) {
            for(int j=0;j<board[i].size();++j) {
                /*
                if(board[i][j] == 'X') {
                    for(int k=i;k<board.size();++k)
                        if(board[k][j] == 'X')
                            board[k][j] = '.';
                        else
                            break;

                    board[i][j] = 'X';
                        
                    for(int k=j;k<board[i].size();++k)
                        if(board[i][k] == 'X')
                            board[i][k] = '.';
                        else
                            break;
                    count++;                    
                }
                */
                
                if(board[i][j] == 'X') {
                    if((i == 0 || board[i-1][j] == '.') && (j == 0 || board[i][j-1] == '.'))
                        count++;
                }
            }
        }
        
        return count;
    }
};
