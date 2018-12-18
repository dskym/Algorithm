#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int dis[101][101];

    for(int i=0;i<101;++i) {
        for(int j=0;j<101;++j) {
            if(i == j)
                dis[i][j] = 0;
            else
                dis[i][j] = 10000001;
        }
    }

    int n, m;
    
    cin >> n;

    cin >> m;

    for(int i=0;i<m;++i) {
        int a, b, c;

        cin >> a >> b >> c;

        dis[a-1][b-1] = min(dis[a-1][b-1], c);
    }

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            for(int k=0;k<n;++k) {
                dis[j][k] = min(dis[j][k], dis[j][i] + dis[i][k]);
            }
        }
    }

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            if(dis[i][j] == 10000001)        
                cout << 0 << " ";
            else
                cout << dis[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}