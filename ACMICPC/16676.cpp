#include <iostream>

using namespace std;

bool check(int temp, int digit) {
    if(temp >= 0 && temp <= 9 && temp == digit) {
        return true;
    } else if(temp % 10 != digit) {
        return false;
    }

    return check(temp / 10, digit);
}

int main() {
    unsigned long long int n;

    cin >> n;

    unsigned long long int temp;

    for(int i=n;i>=0;--i) {
        if(check(i, i % 10) == true) {
            temp = i;
            break;
        }
    }

    int count = 0;

    if(temp == 0)
        cout << 1 << endl;
    else {
        while(temp != 0) {
            temp /= 10;
            count++;
        }

        cout << count << endl;
    }

    return 0;
}