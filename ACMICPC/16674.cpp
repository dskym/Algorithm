#include <iostream>

using namespace std;

int main() {
    unsigned long long int n;

    cin >> n;

    int count[10];

    for(int i=0;i<10;++i)
        count[i] = 0;

    while(n != 0) {
        int temp = n % 10;

        count[temp]++;

        n /= 10;
    }

    bool flag = false;

    for(int i=0;i<10;++i) {
        if(i == 2 || i == 0 || i == 1 || i == 8)
            continue;

        if(count[i] !=0)
            flag = true;
    }
    if(flag == true) {
        cout << 0 << endl;
    } else if(count[2] == count[0] && count[0] == count[1] && count[1] == count[8] && count[8] != 0) {
        cout << 8 << endl;
    } else if(count[2] != 0 && count[0] != 0 && count[1] != 0 && count[8] != 0){
        cout << 2 << endl;
    } else {
        cout << 1 << endl;
    }

    return 0;
}