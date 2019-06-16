#include <iostream>

using namespace std;

int parent[201];
int ranking[201];

void makeSet(int n) {
    for(int i=1;i<=n;++i) {
        parent[i] = i;
        ranking[i] = 0;
    }
}

int findSet(int node) {
    if(parent[node] == node)
        return node;
    else
        return parent[node] = findSet(parent[node]);
}

void unionSet(int x, int y) {
    int u = findSet(x);
    int v = findSet(y);

    if(u == v)
        return;

    if(ranking[u] < ranking[v]) {
        parent[u] = v;
    } else {
        parent[v] = u;

        if(ranking[u] == ranking[v])
            ranking[u]++;
    }
}

int main() {
    int n;

    cin >> n;

    makeSet(n);

    int m;

    cin >> m;

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            int temp;

            cin >> temp;

            if(temp == 1) {
                unionSet(i+1, j+1);
            }
        }
    }

    bool result = true;

    int route[1001];

    for(int i=0;i<m;++i)
        cin >> route[i];

    for(int i=0;i<m-1;++i) {
        if(findSet(route[i]) != findSet(route[i+1])) {
            result = false;
            
            break;
        }
    }

    if(result)
        cout << "YES" << endl;
    else
        cout << "NO" << endl;

    return 0;
}