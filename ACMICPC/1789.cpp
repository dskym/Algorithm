#include <iostream>

using namespace std;

int main() {
    long long int s;

    cin >> s;

    long long int result = 0;
    long long int num = 1;

    while(true) {
        result += num;

        if(s == result) {
            cout << num << endl;
            break;
        } else if(s < result) {
            cout << num - 1 << endl;
            break;
        }

        num++;
    }

    return 0;
}