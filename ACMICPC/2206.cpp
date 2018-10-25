#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

struct data {
    int x;
    int y;
    int count;
    int distance;
};

int main() {

    int n, m;
    char** g;
    bool** visitedZero;
    bool** visitedOne;
    queue<struct data> q;

    int direct[4][2] = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    cin >> n >> m;

    g = new char*[n];
    visitedZero = new bool*[n];
    visitedOne = new bool*[n];

    for(int i=0;i<n;++i) {
        g[i] = new char[m];
        visitedZero[i] = new bool[m];
        visitedOne[i] = new bool[m];
    }

    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            cin >> g[i][j];
        }
    }

    struct data start;
    start.x = 0;
    start.y = 0;
    start.count = 0;
    start.distance = 1;

    q.push(start);

    visitedZero[0][0] = true;
    visitedOne[0][0] = true;

    int result = 1000005;

    while(!q.empty()) {
        struct data temp = q.front();
        q.pop();

        int x = temp.x;
        int y = temp.y;
        int count = temp.count;
        int distance = temp.distance;

        //cout << x << " " << y << " " << count << " " << distance << endl;

        if(x == n-1 && y == m-1) {
            result = min(result, distance);

            continue;
        }

        for(int i=0;i<4;++i) {
            int tx = x + direct[i][0];
            int ty = y + direct[i][1];

            if(tx >= 0 && tx < n && ty >= 0 && ty < m) {
                if(g[tx][ty] == '0' && count == 0 && visitedZero[tx][ty] == false) {
                    struct data t;
                    t.x = tx;
                    t.y = ty;
                    t.count = count;
                    t.distance = distance + 1;

                    q.push(t);

                    visitedZero[tx][ty] = true;
                    visitedOne[tx][ty] = true;
                } else if(g[tx][ty] == '0' && count == 1 && visitedZero[tx][ty] == false && visitedOne[tx][ty] == false) {
                    struct data t;
                    t.x = tx;
                    t.y = ty;
                    t.count = count;
                    t.distance = distance + 1;

                    q.push(t);

                    visitedOne[tx][ty] = true;
                } else if(g[tx][ty] == '1' && count == 0 && visitedOne[tx][ty] == false) {
                    struct data t;
                    t.x = tx;
                    t.y = ty;
                    t.count = count + 1;
                    t.distance = distance + 1;
                    
                    q.push(t);

                    visitedZero[tx][ty] = true;
                    visitedOne[tx][ty] = true;
                }
            }
        }
    }

    if(visitedOne[n-1][m-1] == true || visitedZero[n-1][m-1] == true)
        cout << result << endl;
    else 
        cout << -1 << endl;

    return 0;
}