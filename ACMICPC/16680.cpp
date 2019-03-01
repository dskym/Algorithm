#include <iostream>

using namespace std;

bool check(unsigned long long int n) {
    int sum = 0;

    while(n != 0) {
        sum += n % 10;

        n /= 10;
    }

    if(sum % 2 == 0)
        return true;
    else
        return false;
}

int main() {
    int t;

    cin >> t;

    for(int i=0;i<t;++i) {
        unsigned long long int n;

        cin >> n;

        unsigned long long int base = 111111111;

        while(1) {
            if(check(n * base) == false) {
                cout << n * base << endl;
                break;
            }

            base++;
        }
    }

    return 0;
}