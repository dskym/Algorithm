#include <iostream>
#include <queue>

using namespace std;

int main() {
    int n;
    
    cin >> n;

    int map[21][21];
    int pos[2][4] = {{1, -1, 0, 0},
                    {0, 0, 1, -1}};

    int cx, cy;

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            cin >> map[i][j];

            if(map[i][j] == 9) {
                cx = i;
                cy = j;
            }
        }
    }

    int result = 0;
    int level = 2;
    int eat = 0;

    while(1) {        
        queue<pair<pair<int, int>, int>> q;
        bool visited[21][21];
        int dis[21][21];

        for(int i=0;i<n;++i) {        
            for(int j=0;j<n;++j) {
                visited[i][j] = false;
                dis[i][j] = -1;
            }
        }

        q.push({{cx, cy}, 0});

        visited[cx][cy] = true;

        while(!q.empty()) {
            auto temp = q.front();
            q.pop();

            int temp_x = temp.first.first;
            int temp_y = temp.first.second;
            int d = temp.second;

            dis[temp_x][temp_y] = d;

            for(int i=0;i<4;++i) {
                int px = temp_x + pos[0][i];
                int py = temp_y + pos[1][i];

                if(visited[px][py] == false && px >= 0 && px <= n-1 && py >= 0 && py <= n-1 && map[px][py] <= level) {
                    q.push({{px, py}, d+1});
                    visited[px][py] = true;
                }
            }
        }

        /*
        for(int i=0;i<n;++i) {        
            for(int j=0;j<n;++j) {
                cout << dis[i][j] << " ";
            }
            cout << endl;
        }
        */

        bool flag = false;
        int eat_x=-1, eat_y=-1;
        int eat_dis = 500;

        for(int i=0;i<n;++i) {        
            for(int j=0;j<n;++j) {
                if(map[i][j] != 0 && dis[i][j] != -1 && dis[i][j] != 0 && map[i][j] < level) {
                    if(eat_dis > dis[i][j]) {
                        eat_x = i;
                        eat_y = j;
                        eat_dis = dis[i][j];
                        flag = true;
                    }
                }
            }
        }

        if(eat_x == -1 && eat_y == -1)
            break;

        result += eat_dis;
        
        map[cx][cy] = 0;

        cx = eat_x;
        cy = eat_y;

        //cout << cx << " " << cy << endl;

        map[cx][cy] = 9;

        eat++;

        if(eat == level) {
            level++;
            eat = 0;
        }

        if(flag == false)
            break;
    }

    cout << result << endl;

    return 0;
}