#include <iostream>
#include <queue>

using namespace std;

int main() {
    int r, c;

    cin >> r >> c;

    char map[51][51];
    int water[51][51];
    bool visited[51][51];

    int sx, sy;
    int dx, dy;

    queue<pair<pair<int, int>, int>> w;

    for(int i=0;i<r;++i) {
        for(int j=0;j<c;++j) {
            cin >> map[i][j];

            if(map[i][j] == 'D') {
                dx = i;
                dy = j;
            }

            if(map[i][j] == 'S') {
                sx = i;
                sy = j;
            }

            visited[i][j] = false;
            water[i][j] = 100000;

            if(map[i][j] == '*') {
                w.push({{i, j}, 0});
                visited[i][j] = true;
            }
        }
    }

    while(!w.empty()) {
        auto temp = w.front();
        w.pop();

        int x = temp.first.first;
        int y = temp.first.second;
        int pos = temp.second;

        water[x][y] = pos;
        
        if(x > 0 && visited[x-1][y] == false && map[x-1][y] == '.') {
            visited[x-1][y] = true;
            w.push({{x-1, y}, pos+1});
        }
        if(x < r-1 && visited[x+1][y] == false && map[x+1][y] == '.') {
            visited[x+1][y] = true;
            w.push({{x+1, y}, pos+1});
        }
        if(y > 0 && visited[x][y-1] == false && map[x][y-1] == '.') {
            visited[x][y-1] = true;
            w.push({{x, y-1}, pos+1});
        }
        if(y < c-1 && visited[x][y+1] == false && map[x][y+1] == '.') {
            visited[x][y+1] = true;
            w.push({{x, y+1}, pos+1});
        }
    }

    /*
    for(int i=0;i<r;++i) {
        for(int j=0;j<c;++j) {
            cout << water[i][j] << " ";
        }
        cout << endl;
    }
    */

    for(int i=0;i<r;++i) {
        for(int j=0;j<c;++j) {
            visited[i][j] = false;
        }
    }

    queue<pair<pair<int, int>, int>> q;
    q.push({{sx, sy}, 0});
    visited[sx][sy] = true;

    int result = -1;

    while(!q.empty()) {
        auto temp = q.front();
        q.pop();

        int x = temp.first.first;
        int y = temp.first.second;
        int pos = temp.second;

        //cout << x << " " << y << " " << pos << endl;

        if(x == dx && y == dy && pos < water[x][y]) {
            result = pos;
            break;
        }
        
        if(x > 0 && visited[x-1][y] == false && (map[x-1][y] == '.' || map[x-1][y] == 'D') && pos+1 < water[x-1][y]) {
            visited[x-1][y] = true;
            q.push({{x-1, y}, pos+1});
        }
        if(x < r-1 && visited[x+1][y] == false && (map[x+1][y] == '.' || map[x+1][y] == 'D') && pos+1 < water[x+1][y]) {
            visited[x+1][y] = true;
            q.push({{x+1, y}, pos+1});
        }
        if(y > 0 && visited[x][y-1] == false && (map[x][y-1] == '.' || map[x][y-1] == 'D') && pos+1 < water[x][y-1]) {
            visited[x][y-1] = true;
            q.push({{x, y-1}, pos+1});
        }
        if(y < c-1 && visited[x][y+1] == false && (map[x][y+1] == '.' || map[x][y+1] == 'D') && pos+1 < water[x][y+1]) {
            visited[x][y+1] = true;
            q.push({{x, y+1}, pos+1});
        }
    }

    if(result == -1)
        cout << "KAKTUS" << endl;
    else
        cout << result << endl;

    return 0;
}