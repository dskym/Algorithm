#include <iostream>
#include <string>

using namespace std;

int main() {
    int dp[5001];
    string s;

    cin >> s;

    int len = s.length();

    for(int i=0;i<5001;++i)
        dp[i] = 0;

    if(len >= 1) {
        if('1' <= s[len-1] && s[len-1] <= '9')
            dp[len-1] = 1;
    }

    if(len >= 2) {
        if('1' <= s[len-2] && s[len-2] <= '9')
            dp[len-2] = dp[len-1] + dp[len-2];

        if(stoi(s.substr(len-2, 2)) == 10)
            dp[len-2] = 1;

        if(11 <= stoi(s.substr(len-2, 2)) && stoi(s.substr(len-2, 2)) <= 26)
            dp[len-2] = 2;
    }

    for(int i=len-3;i>=0;--i) {
        if('1' <= s[i] && s[i] <= '9')
            dp[i] = (dp[i+1] + dp[i]) % 1000000;

        if(10 <= stoi(s.substr(i, 2)) && stoi(s.substr(i, 2)) <= 26)
            dp[i] = (dp[i+2] + dp[i]) % 1000000;
    }

    cout << dp[0] << endl;

    return 0;
}