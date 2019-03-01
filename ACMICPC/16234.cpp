#include <iostream>
#include <queue>

using namespace std;

int main() {
    int n, l, r;

    cin >> n >> l >> r;

    int map[51][51];
    int pos[2][4] = {{1, -1, 0, 0},
                    {0, 0, 1, -1}};

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            cin >> map[i][j];
        }
    }

    int result = 0;

    while(1) {
        queue<pair<int, int>> q;

        int dis[51][51];
        bool visited[51][51];

        int dis_sum[2501];
        int dis_count[2501];

        for(int i=0;i<2501;++i) {
            dis_count[i] = 0;
            dis_sum[i] = 0;
        }

        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                dis[i][j] = 0;
                visited[i][j] = false;
            }
        }

        int count = 1;
        bool flag = false;

        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(visited[i][j] == true)
                    continue;

                q.push({i, j});

                while(!q.empty()) {
                    auto temp = q.front();
                    q.pop();

                    int cx = temp.first;
                    int cy = temp.second;

                    visited[cx][cy] = true;
                    dis[cx][cy] = count;

                    for(int j=0;j<4;++j) {
                        int tx = cx + pos[0][j];
                        int ty = cy + pos[1][j];

                        if(tx >= 0 && tx <= n-1 && ty >= 0 && ty <= n-1 && visited[tx][ty] == false && abs(map[tx][ty] - map[cx][cy]) >= l && abs(map[tx][ty] - map[cx][cy]) <= r) {
                            visited[tx][ty] = true;
                            q.push({tx, ty});
                            flag = true;
                        }
                    }
                }

                count++;
            }
        }

        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(dis[i][j] != 0) {
                    dis_sum[dis[i][j]] += map[i][j];
                    dis_count[dis[i][j]] += 1;
                }
            }
        }

        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(dis[i][j] != 0) {
                    map[i][j] = dis_sum[dis[i][j]] / dis_count[dis[i][j]];
                }
            }
        }

        if(flag == false)
            break;

        result++;
    }

    cout << result << endl;

    return 0;
}