#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int dp[21][301];
int price[301][22];
int n, m;

vector<int> path;

void backtracking(int num, int asset, int maxProfit) {
    if(num == m - 1) {
        path.push_back(asset);
        return;
    }

    for(int i=0;i<=asset;++i) {
        if(i == 0 && maxProfit == dp[num+1][asset]) {
            path.push_back(i);
            backtracking(num + 1, asset, maxProfit);
            break;
        } else if(maxProfit - price[i-1][num+1] == dp[num+1][asset-i]) {
            path.push_back(i);
            backtracking(num + 1, asset - i, maxProfit - price[i-1][num+1]);
            break;
        }
    }
}

int solve(int num, int asset) {
    if(asset == 0) {
        dp[num][asset] = 0;

        return dp[num][asset];
    }

    if(num == m - 1) {
        dp[num][asset] = price[asset-1][num+1];

        return dp[num][asset];
    }

    if(dp[num][asset] != -1)
        return dp[num][asset]; 

    int temp = 0;

    for(int i=0;i<=asset;++i) {
        if(i == 0) {
            temp = max(temp, solve(num+1, asset));
        } else {
            temp = max(temp, solve(num+1, asset-i) + price[i-1][num+1]);
        }
    }

    dp[num][asset] = temp;


    return dp[num][asset];
}

int main() {

    for(int i=0;i<21;++i) {
        for(int j=0;j<301;++j) {
            dp[i][j] = -1;
        }
    }

    cin >> n >> m;

    for(int i=0;i<n;++i) {
        for(int j=0;j<=m;++j) {
            cin >> price[i][j];
        }
    }

    int result = solve(0, n);

    cout << result << endl;

    backtracking(0, n, result);

    for(int i=path.size();i<m;++i)
        path.push_back(0);

    for(int i=0;i<m;++i) {
        if(i != m - 1)
            cout << path[i] << " ";
        else
            cout << path[i];
    }

    cout << endl;

    for(int i=0;i<m;++i) {
        for(int j=0;j<=n;++j) {
            cout << dp[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
