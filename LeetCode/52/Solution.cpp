class Solution {
public:
    int map[101][101];
    
    bool check(int x, int y, int n) {
        for(int i=0;i<n;++i) {
            if(map[x][i])
                return false;
            
            if(map[i][y])
                return false;
        }
        
        for(int i=0;i<n;++i) {
            if(x+i < n && y+i < n && map[x+i][y+i])
                return false;
            
            if(x-i >= 0 && y-i >= 0 && map[x-i][y-i])
                return false;

            if(x+i < n && y-i >= 0 && map[x+i][y-i])
                return false;
            
            if(x-i >= 0 && y+i < n && map[x-i][y+i])
                return false;
        }
        
        return true;
    }
    
    int solve(int row, int n) {
        if(row == n)
            return 1;
        
        int result = 0;
        
        for(int i=0;i<n;++i) {
            if(check(row, i, n)) {
                map[row][i] = 1;
                result += solve(row+1, n);
                map[row][i] = 0;
            }
        }
        
        return result;
    }
    
    int totalNQueens(int n) {
        int result = 0;
        
        for(int i=0;i<n;++i) {
            map[0][i] = 1;
            result += solve(1, n);
            map[0][i] = 0;
        }
        
        return result;
    }
};
