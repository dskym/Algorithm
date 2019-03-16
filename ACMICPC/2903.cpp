#include <iostream>

using namespace std;

int main() {
    int n;

    cin >> n;

    unsigned long long int dot = 2;

    for(int i=0;i<n;++i) {
        dot = dot * 2 - 1;
    }

    cout << dot * dot << endl;

    return 0;
}