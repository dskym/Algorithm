#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    bool primary[10001];

    for(int i=0;i<10001;++i)
        primary[i] = true;

    primary[0] = false;
    primary[1] = false;

    for(int i=2;i<10000;++i) {
        if(primary[i] == true) {
            for(int j=i*i;j<10000;j+=i) {
                primary[j] = false;
            }
        }
    }

    vector<int> temp;

    for(int i=1000;i<10000;++i)
        if(primary[i] == true)
            temp.push_back(i);

    int test;

    cin >> test;

    for(int testcase=0;testcase<test;++testcase) {
        int g[1100][1100];
        bool visited[1100];

        int start;
        int end;

        cin >> start >> end;

        int startIndex;
        int endIndex;

        for(int i=0;i<1100;++i)
            visited[i] = false;

        for(int i=0;i<temp.size();++i) {
            if(temp[i] == start)
                startIndex = i;

            if(temp[i] == end)
                endIndex = i;
        }

        for(int i=0;i<temp.size();++i) {
            for(int j=0;j<temp.size();++j) {
                int first[4] = {
                    temp[i] / 1000,
                    temp[i] / 100 % 10,
                    temp[i] / 10 % 10,
                    temp[i] % 10
                };

                int second[4] = {
                    temp[j] / 1000,
                    temp[j] / 100 % 10,
                    temp[j] / 10 % 10,
                    temp[j] % 10
                };

                if(first[0] != second[0] && first[1] == second[1] && first[2] == second[2] && first[3] == second[3]) {
                    g[i][j] = 1;
                    g[j][i] = 1;
                }

                if(first[0] == second[0] && first[1] != second[1] && first[2] == second[2] && first[3] == second[3]) {
                    g[i][j] = 1;
                    g[j][i] = 1;
                }

                if(first[0] == second[0] && first[1] == second[1] && first[2] != second[2] && first[3] == second[3]) {
                    g[i][j] = 1;
                    g[j][i] = 1;
                }

                if(first[0] == second[0] && first[1] == second[1] && first[2] == second[2] && first[3] != second[3]) {
                    g[i][j] = 1;
                    g[j][i] = 1;
                }
            }
        }

        queue<pair<int, int>> q;

        q.push(make_pair(startIndex, 0));
        visited[startIndex] = true;

        while(!q.empty()) {
            auto t = q.front();
            q.pop();

            int tempIndex = t.first;
            int dis = t.second;

            if(tempIndex == endIndex) {
                cout << dis << endl;
                break;
            }

            for(int i=0;i<1100;++i) {
                if(g[tempIndex][i] == 1 && visited[i] == false) {
                    q.push(make_pair(i, dis + 1));
                    visited[i] = true;
                }
            }
        }
    }

    return 0;
}