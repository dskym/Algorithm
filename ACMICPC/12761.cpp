#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int a, b, n, m;
    bool visited[100001];
    queue<pair<int, int>> q;

    for(int i=0;i<100001;++i)
        visited[i] = false;

    cin >> a >> b >> n >> m;

    q.push(make_pair(n, 0));
    visited[n] = true;

    int result = 200001;

    while(!q.empty()) {
        auto temp = q.front();
        q.pop();

        int pos = temp.first;
        int count = temp.second;

        if(pos == m)
            result = min(result, count);

        if(pos * a <= 100000 && pos * a >= 0 && visited[pos * a] == false) {
            q.push(make_pair(pos * a, count + 1));
            visited[pos * a] = true;
        }

        if(pos * b <= 100000 && pos * b >= 0 && visited[pos * b] == false) {
            q.push(make_pair(pos * b, count + 1));
            visited[pos * b] = true;
        }

        if(pos + a <= 100000 && visited[pos + a] == false) {
            q.push(make_pair(pos + a, count + 1));
            visited[pos + a] = true;
        }

        if(pos + b <= 100000 && visited[pos + b] == false) {
            q.push(make_pair(pos + b, count + 1));
            visited[pos + b] = true;
        }

        if(pos + 1 <= 100000 && visited[pos + 1] == false) {
            q.push(make_pair(pos + 1, count + 1));
            visited[pos + 1] = true;
        }

        if(pos - 1 >= 0 && visited[pos - 1] == false) {
            q.push(make_pair(pos - 1, count + 1));
            visited[pos - 1] = true;
        }

        if(pos - a >= 0 && visited[pos - a] == false) {
            q.push(make_pair(pos - a, count + 1));
            visited[pos - a] = true;
        }

        if(pos - b >= 0 && visited[pos - b] == false) {
            q.push(make_pair(pos - b, count + 1));
            visited[pos - b] = true;
        }
    }

    cout << result << endl;
}