#include <iostream>
#include <algorithm>

using namespace std;

int n, m;
char** g;
int** dp;

int main() {

    cin >> n >> m;

    g = new char*[n+1];
    dp = new int*[n+1];

    for(int i=0;i<=n;++i) {
        g[i] = new char[m+1];
        dp[i] = new int[m+1];
    }

    for(int i=1;i<=n;++i) {
        for(int j=1;j<=m;++j) {
            dp[i][j] = 0;
        }
    }

    for(int i=1;i<=n;++i) {
        for(int j=1;j<=m;++j) {
            cin >> g[i][j];
        }
    }

    int result = 0;

    for(int i=1;i<=n;++i) {
        for(int j=1;j<=m;++j) {
            if(g[i][j] == '1') {
                dp[i][j] = min({dp[i-1][j], dp[i][j-1], dp[i-1][j-1]}) + 1;
                result = max(result, dp[i][j]);
            }
        }
    }

    cout << result * result << endl;

    return 0;
}