#include <queue>

class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        int g[1001][1001];
        bool visited[1001];
        
        for(int i=0;i<1001;++i) {
            for(int j=0;j<1001;++j) {
                g[i][j] = 0;
            }
        }

        for(int i=0;i<rooms.size();++i) {
            for(int j=0;j<rooms[i].size();++j) {
                g[i][rooms[i][j]] = 1;
            }
        }
        
        for(int i=0;i<rooms.size();++i)
            visited[i] = false;
        
        queue<int> q;
        
        q.push(0);
        visited[0] = true;
                
        while(!q.empty()) {
            auto t = q.front();
            q.pop();
            
            for(int i=0;i<rooms.size();++i) {
                if(visited[i] == false && g[t][i] == 1) {
                    q.push(i);
                    visited[i] = true;
                }
            }
        }
        
        bool result = true;
        
        for(int i=0;i<rooms.size();++i) {
            if(visited[i] == false) {
                result = false;
                break;
            }
        }
            
        return result;
    }
};
