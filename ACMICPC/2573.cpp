#include <iostream>
#include <queue>

using namespace std;

int n, m;
int g[301][301];

bool remove() {    
    bool visited[301][301];
    int count = 0;
    int near[301][301];

    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            visited[i][j] = false;
            near[i][j] = 0;
        }
    }

    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            if(visited[i][j] == true || g[i][j] == 0)
                continue;

            queue<pair<int, int>> q;

            if(g[i][j] != 0) {
                q.push({i, j});

                count++;
            }

            visited[i][j] = true;

            while(!q.empty()) {
                auto pos = q.front();
                q.pop();

                int x = pos.first;
                int y = pos.second;

                if(g[x][y]-near[x][y] > 0 && x > 0 && g[x-1][y] == 0)
                    near[x][y]++;

                if(g[x][y]-near[x][y] > 0 && x < n-1 && g[x+1][y] == 0)
                    near[x][y]++;

                if(g[x][y]-near[x][y] > 0 && y > 0 && g[x][y-1] == 0)
                    near[x][y]++;

                if(g[x][y]-near[x][y] > 0 && y < m-1 && g[x][y+1] == 0)
                    near[x][y]++;


                if(x > 0 && g[x-1][y] != 0 && visited[x-1][y] == false) {
                    visited[x-1][y] = true;
                    q.push({x-1,y});
                }

                if(x < n-1 && g[x+1][y] != 0 && visited[x+1][y] == false) {
                    visited[x+1][y] = true;
                    q.push({x+1,y});
                }

                if(y > 0 && g[x][y-1] != 0 && visited[x][y-1] == false) {
                    visited[x][y-1] = true;
                    q.push({x,y-1});
                }

                if(y < m-1 && g[x][y+1] != 0 && visited[x][y+1] == false) {
                    visited[x][y+1] = true;
                    q.push({x,y+1});
                }
            }
        }
    }

    if(count == 1) {
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(g[i][j]-near[i][j] < 0)
                    g[i][j] = 0;
                else
                    g[i][j] -= near[i][j];
            }
        }

        return false;
    }
    
    return true;
}

int main() {
    cin >> n >> m;

    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            cin >> g[i][j];
        }
    }

    int result = 0;

    while(1) { 
        bool flag = remove();

        if(flag == true)
            break;

        result++;
    }

    bool flag = false;

    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            if(g[i][j] != 0)
                flag = true;
        }
    }

    if(flag == true)
        cout << result << endl;
    else
        cout << 0 << endl;

    return 0;
}