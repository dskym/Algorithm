class Solution {
public:
    vector<vector<int>> queensAttacktheKing(vector<vector<int>>& queens, vector<int>& king) {
        bool map[8][8];
        
        for(int i=0;i<8;++i)
            for(int j=0;j<8;++j)
                map[i][j] = false;
        
        for(auto queen : queens)
            map[queen[0]][queen[1]] = true;
        
        vector<vector<int>> result;

        int x = king[0];
        int y = king[1];
        
        for(int i=x+1;i<8;++i) {
            if(map[i][y] == true) {
                result.push_back({i, y});
                break;
            }
        }
        
        for(int i=x-1;i>=0;--i) {
            if(map[i][y] == true) {
                result.push_back({i, y});
                break;
            }
        }

        for(int i=y-1;i>=0;--i) {
            if(map[x][i] == true) {
                result.push_back({x, i});
                break;
            }
        }
        
        for(int i=y+1;i<8;++i) {
            if(map[x][i] == true) {
                result.push_back({x, i});
                break;
            }
        }
        
        for(int i=0;i<8;++i) {
            if(x+i < 8 && y+i < 8 && map[x+i][y+i] == true) {
                result.push_back({x+i, y+i});
                break;
            }
        }

        for(int i=0;i<8;++i) {
            if(x+i < 8 && y-i >= 0 && map[x+i][y-i] == true) {
                result.push_back({x+i, y-i});
                break;
            }
        }
        
        for(int i=0;i<8;++i) {
            if(x-i >= 0 && y+i < 8 && map[x-i][y+i] == true) {
                result.push_back({x-i, y+i});
                break;
            }
        }
        
        for(int i=0;i<8;++i) {
            if(x-i >= 0 && y-i >= 0 && map[x-i][y-i] == true) {
                result.push_back({x-i, y-i});
                break;
            }
        }

        return result;
    }
};
