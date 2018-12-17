#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n, m;

    cin >> n >> m;

    int a[101];
    int c[101];

    int dp[101][10001];

    for(int i=0;i<n;++i)
        cin >> a[i];

    for(int i=0;i<n;++i)
        cin >> c[i];

    for(int i=0;i<101;++i)
        for(int j=0;j<10001;++j)
            dp[i][j] = -1;

    dp[0][0] = 0;
    dp[0][c[0]] = a[0];

    for(int i=1;i<n;++i) {
        dp[i][c[i]] = a[i];

        for(int j=0;j<10001;++j)
            if(dp[i-1][j] != -1)
                dp[i][j] = dp[i-1][j];

        for(int j=0;j<10001;++j) {
            if(j-c[i] >= 0 && dp[i-1][j-c[i]] != -1)
                dp[i][j] = max(dp[i][j], dp[i-1][j-c[i]] + a[i]);
        }
    }

    int result = 20001;

    for(int i=0;i<n;++i) {
        for(int j=0;j<10001;++j) {
            if(dp[i][j] >= m) {
                result = min(result, j);
            }
        }
    }

    cout << result << endl;

    return 0;
}