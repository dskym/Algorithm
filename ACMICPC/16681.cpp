#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int n, m, d, e;

    cin >> n >> m >> d >> e;

    int h[100001];
    vector<pair<long long int, int>> g[100001];

    for(int i=0;i<n;++i) {
        cin >> h[i];
    }

    for(int i=0;i<m;++i) {
        int a, b, dis;

        cin >> a >> b >> dis;

        g[a-1].push_back({dis, b-1});
        g[b-1].push_back({dis, a-1});
    }

    long long int dis_f[100001];

    priority_queue<pair<long long int, int>> q;

    for(int i=0;i<n;++i) {
        dis_f[i] = 1000000000000;
    }

    q.push({0, 0});

    while(!q.empty()) {
        auto temp = q.top();
        q.pop();

        long long int dis = -1 * temp.first;
        int start = temp.second;

        if(dis_f[start] != 1000000000000)
            continue;

        dis_f[start] = dis;

        for(int i=0;i<g[start].size();++i) {
            int temp_v = g[start][i].second;
            long long int temp_dis = dis_f[start]+g[start][i].first;

            if(dis_f[temp_v] != 1000000000000)
                continue;

            if(h[start] < h[temp_v]) {
                q.push({-1 * temp_dis, temp_v});
            }
        }
    }

    /*
    for(int i=0;i<n;++i) {
        cout << i+1 << " " << dis_f[i] << endl;
    }
    */

    long long int dis_e[100001];

    for(int i=0;i<n;++i) {
        dis_e[i] = 1000000000000;
    }

    q.push({0, n-1});

    while(!q.empty()) {
        auto temp = q.top();
        q.pop();

        long long int dis = -1 * temp.first;
        int start = temp.second;

        if(dis_e[start] != 1000000000000)
            continue;

        dis_e[start] = dis;

        for(int i=0;i<g[start].size();++i) {
            int temp_v = g[start][i].second;
            long long int temp_dis = dis_e[start]+g[start][i].first;

            if(dis_e[temp_v] != 1000000000000)
                continue;

            if(h[start] < h[temp_v]) {
                q.push({-1 * temp_dis, temp_v});
            }
        }
    }

    /*
    for(int i=0;i<n;++i) {
        cout << i+1 << " " << dis_e[i] << endl;
    }
    */

    bool flag = false;
    long long int result;    

    for(int i=0;i<n;++i) {
        if(dis_f[i] != 1000000000000 && dis_e[i] != 1000000000000) {
            result = e * h[i] - (dis_f[i] + dis_e[i]) * d;
            flag = true;

            break;
        }
    }

    for(int i=0;i<n;++i) {
        if(dis_f[i] != 1000000000000 && dis_e[i] != 1000000000000) {
            if(result < e * h[i] - (dis_f[i] + dis_e[i]) * d)
                result = e * h[i] - (dis_f[i] + dis_e[i]) * d;
        }
    }

    if(flag == false) {
        cout << "Impossible" << endl;
    } else {
        cout << result << endl;
    }

    return 0;
}