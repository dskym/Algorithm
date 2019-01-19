#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int l, w;
    char map[51][51];

    cin >> l >> w;

    for(int i=0;i<l;++i) {
        for(int j=0;j<w;++j) {
            cin >> map[i][j];
        }
    }

    int result = 0;

    for(int i=0;i<l;++i) {
        for(int j=0;j<w;++j) {
            if(map[i][j] == 'W')
                continue;

            //{{x, y}, distance}
            queue<pair<pair<int, int>, int>> q;
            bool visited[51][51];

            for(int i=0;i<51;++i)
                for(int j=0;j<51;++j)
                    visited[i][j] = false;

            q.push({{i, j}, 0});
            visited[i][j] = true;

            int maxDis = 0;

            while(!q.empty()) {
                auto temp = q.front();
                q.pop();

                auto pos = temp.first;

                int x = pos.first;
                int y = pos.second;
                int distance = temp.second;

                maxDis = max(maxDis, distance);

                if(map[x+1][y] == 'L' && visited[x+1][y] == false && x+1 < l) {
                    visited[x+1][y] = true;
                    q.push({{x+1, y}, distance+1});
                }
                if(map[x-1][y] == 'L' && visited[x-1][y] == false && x-1 >= 0) {
                    visited[x-1][y] = true;
                    q.push({{x-1, y}, distance+1});
                }
                if(map[x][y+1] == 'L' && visited[x][y+1] == false && y+1 < w) {
                    visited[x][y+1] = true;
                    q.push({{x, y+1}, distance+1});
                }
                if(map[x][y-1] == 'L' && visited[x][y-1] == false && y-1 >= 0) {
                    visited[x][y-1] = true;
                    q.push({{x, y-1}, distance+1});
                }
            }

            //cout << i << " " << j << " " << maxDis << endl;

            result = max(result, maxDis);
        }
    }

    cout << result << endl;

    return 0;
}