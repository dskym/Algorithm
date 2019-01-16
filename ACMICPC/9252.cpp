#include <iostream>
#include <algorithm>

using namespace std;

string a;
string b;

int dp[1001][1001];

int lcs(int indexA, int indexB) {
    if(indexA >= a.length() || indexB >= b.length()) {
        return 0;
    }

    if(dp[indexA][indexB] != -1)
        return dp[indexA][indexB];

    if(a[indexA] == b[indexB]) {
        dp[indexA][indexB] = 1 + lcs(indexA+1, indexB+1);

        return dp[indexA][indexB];
    } else {
        int tempA = lcs(indexA+1, indexB);
        int tempB = lcs(indexA, indexB+1);

        dp[indexA][indexB] = max(tempA, tempB);

        return dp[indexA][indexB];
    }
}

string backtracking(int indexA, int indexB, int result) {
    if(indexA >= a.length() || indexB >= b.length()) {
        return "";
    }

    if(a[indexA] == b[indexB] && dp[indexA][indexB] == result) {
        return a[indexA] + backtracking(indexA+1, indexB+1, result-1);
    } else {
        int tempA = dp[indexA+1][indexB];
        int tempB = dp[indexA][indexB+1];

        if(tempA > tempB) {
            return backtracking(indexA+1, indexB, result);
        } else {
            return backtracking(indexA, indexB+1, result);
        }
    }
}

int main() {
    cin >> a;
    cin >> b;

    for(int i=0;i<1001;++i)
        for(int j=0;j<1001;++j)
            dp[i][j] = -1;

    int result = lcs(0, 0);

    cout << result << endl;

    cout << backtracking(0, 0, result) << endl;

    return 0;
}