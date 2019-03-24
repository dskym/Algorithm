#include <iostream>

using namespace std;

int main() {
    int n, a, b;

    cin >> n >> a >> b;

    int count = 1;
    bool flag = false;

    while(true) {
        if(a+1 == b && a%2 == 1 && b%2 == 0) {
            flag = true;
            break;
        }

        if(b+1 == a && b%2 == 1 && a%2 == 0) {
            flag = true;
            break;
        }

        a = a / 2 + a % 2;
        b = b / 2 + b % 2;

        count++;
    }

    if(flag == true)
        cout << count << endl;
    else
        cout << -1 << endl;

    return 0;
}