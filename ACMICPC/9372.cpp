#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int t;

    cin >> t;

    for(int i=0;i<t;++i) {
        int n, m;

        cin >> n >> m;

        vector<int> v[1001];
        bool visited[1001];

        for(int j=0;j<1001;++j)
            visited[j] = false;

        for(int j=0;j<m;++j) {
            int a, b;

            cin >> a >> b;

            v[a-1].push_back(b-1);
            v[b-1].push_back(a-1);
        }

        queue<int> q;

        int start = -1;

        int result = 0;

        for(int j=0;j<n;++j) {
            if(visited[j] == false && v[j].size() != 0) {
                start = j;
                break;
            }
        }

        q.push(start);
        visited[start] = true;

        while(!q.empty()) {
            int node = q.front();
            q.pop();

            for(int j=0;j<v[node].size();++j) {
                if(visited[v[node][j]] == false) {
                    q.push(v[node][j]);
                    visited[v[node][j]] = true;
                    result++;
                }
            }
        }

        cout << result << endl;
    }

    return 0;
}