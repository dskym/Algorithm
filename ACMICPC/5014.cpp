#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    int f, s, g, u, d;

    cin >> f >> s >> g >> u >> d;

    bool visited[1000001];

    for(int i=0;i<1000001;++i)
        visited[i] = false;
    
    queue<pair<int, int>> q;

    q.push({s, 0});
    visited[s] = true;

    int result = 2000000;

    while(!q.empty()) {
        auto temp = q.front();
        q.pop();

        int pos = temp.first;
        int dis = temp.second;

        if(pos == g) {
            result = min(result, dis);
            break;
        }

        if(visited[pos+u] == false && pos+u <= f) {
            q.push({pos+u, dis+1});
            visited[pos+u] = true;
        }

        if(visited[pos-d] == false && pos-d >= 1) {
            q.push({pos-d, dis+1});
            visited[pos-d] = true;
        }
    }

    if(result == 2000000)
        cout << "use the stairs" << endl;
    else
        cout << result << endl;

    return 0;
}