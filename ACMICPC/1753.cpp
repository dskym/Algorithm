#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    int v, e;
    int dis[20001];
    bool visited[20001];

    cin >> v >> e;

    int k;

    cin >> k;

    vector<pair<int, int>> g[20001];

    for(int i=0;i<20001;++i) {
        visited[i] = false;
        dis[i] = 10000000;
    }

    for(int i=0;i<e;++i) {
        int u, v, w;

        cin >> u >> v >> w;

        g[u-1].push_back({v-1, w});
    }

    priority_queue<pair<int, int>> q;

    q.push({0, k-1});

    while(!q.empty()) {
        auto node = q.top();
        q.pop();

        int distance = -1 * node.first;
        int src = node.second;

        //cout << src << " " << distance << endl;

        if(visited[src] == true)
            continue;

        visited[src] = true;
        dis[src] = distance;

        for(int i=0;i<g[src].size();++i) {
            if(dis[g[src][i].first] > distance + g[src][i].second) {
                q.push({(distance + g[src][i].second) * -1, g[src][i].first});
            }
        }
    }

    for(int i=0;i<v;++i) {
        if(dis[i] == 10000000)
           cout << "INF" << '\n';
        else
           cout << dis[i] << '\n';
    }

    return 0;
}
