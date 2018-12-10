#include <iostream>

using namespace std;

int main() {
    int n, t;

    cin >> n >> t;

    int sum = 0;
    int i;

    for(i=1;i<=n;++i) {
        int temp;

        cin >> temp;

        sum += temp;

        if(sum > t)
            break;
    }

    cout << i - 1 << endl;    

    return 0;
}