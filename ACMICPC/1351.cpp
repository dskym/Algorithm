#include <iostream>

using namespace std;

unsigned long long int n, p, q;
unsigned long long int dp[10000001];

unsigned long long int solve(unsigned long long int t) {
    if(t == 0) {
        return 1;
    }

    if(t < 10000001 && dp[t] != -1)
        return dp[t];

    unsigned long long int temp1 = solve(t / p);

    if(t / p < 10000001)
        dp[t / p] = temp1;

    unsigned long long int temp2 = solve(t / q);

    if(t / q < 10000001)
        dp[t / q] = temp2;

    return temp1 + temp2;
}

int main() {
    cin >> n >> p >> q;

    for(int i=0;i<10000001;++i)
        dp[i] = -1;

    cout << solve(n) << endl;

    return 0;
}