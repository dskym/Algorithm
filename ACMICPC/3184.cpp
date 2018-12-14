#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {

    char data[251][251];
    bool visited[251][251];

    int r, c;

    cin >> r >> c;

    int sheep = 0;
    int wolf = 0;

    for(int i=0;i<251;++i)
        for(int j=0;j<251;++j)
        visited[i][j] = false;

    for(int i=0;i<r;++i)
        for(int j=0;j<c;++j)
            cin >> data[i][j];

    for(int i=0;i<r;++i) {
        for(int j=0;j<c;++j) {
            if(visited[i][j] == false) {
                int tempSheep = 0;
                int tempWolf = 0;

                queue<pair<int, int>> q;

                q.push(make_pair(i, j));
                visited[i][j] = true;

                while(!q.empty()) {
                    auto pos = q.front();
                    q.pop();

                    int tx = pos.first;
                    int ty = pos.second;

                    if(data[tx][ty] == 'v')
                        tempWolf++;

                    if(data[tx][ty] == 'o')
                        tempSheep++;

                    if(tx-1 >= 0 && visited[tx-1][ty] == false && data[tx-1][ty] != '#') {
                        q.push(make_pair(tx-1, ty));
                        visited[tx-1][ty] = true;
                    }

                    if(tx+1 < r && visited[tx+1][ty] == false && data[tx+1][ty] != '#') {
                        q.push(make_pair(tx+1, ty));
                        visited[tx+1][ty] = true;
                    }

                    if(ty-1 >= 0 && visited[tx][ty-1] == false && data[tx][ty-1] != '#') {
                        q.push(make_pair(tx, ty-1));
                        visited[tx][ty-1] = true;
                    }

                    if(ty+1 < c && visited[tx][ty+1] == false && data[tx][ty+1] != '#') {
                        q.push(make_pair(tx, ty+1));
                        visited[tx][ty+1] = true;
                    }
                }

                if(tempSheep <= tempWolf)
                    wolf += tempWolf;
                else
                    sheep += tempSheep;
            }
        }
    }

    cout << sheep << " " << wolf << endl;

    return 0;
}