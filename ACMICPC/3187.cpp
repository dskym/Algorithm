#include <iostream>
#include <queue>

using namespace std;

int main() {
    int r, c;

    cin >> r >> c;

    char map[251][251];
    bool visited[251][251];

    for(int i=0;i<r;++i) {
        for(int j=0;j<c;++j) {
            cin >> map[i][j];
            visited[i][j] = false;
        }
    }

    int sheep = 0;
    int wolf = 0;

    for(int i=0;i<r;++i) {
        for(int j=0;j<c;++j) {
            if(map[i][j] == '#' || visited[i][j] == true)
                continue;
            
            queue<pair<int, int>> q;

            q.push({i, j});
            visited[i][j] = true;

            int local_sheep = 0;
            int local_wolf = 0;

            while(!q.empty()) {
                auto temp = q.front();
                q.pop();

                int x = temp.first;
                int y = temp.second;

                if(map[x][y] == 'k')
                    local_sheep++;

                if(map[x][y] == 'v')
                    local_wolf++;

                if(x > 0 && map[x-1][y] != '#' && visited[x-1][y] == false) {
                    q.push({x-1, y});
                    visited[x-1][y] = true;
                }

                if(x < r-1 && map[x+1][y] != '#' && visited[x+1][y] == false) {
                    q.push({x+1, y});
                    visited[x+1][y] = true;
                }

                if(y > 0 && map[x][y-1] != '#' && visited[x][y-1] == false) {
                    q.push({x, y-1});
                    visited[x][y-1] = true;
                }

                if(y < c-1 && map[x][y+1] != '#' && visited[x][y+1] == false) {
                    q.push({x, y+1});
                    visited[x][y+1] = true;
                }
            }

            if(local_sheep > local_wolf)
                sheep += local_sheep;
            else
                wolf += local_wolf;
        }
    }

    cout << sheep << " " << wolf << endl;

    return 0;
}