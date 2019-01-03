#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    string str;
    char s[1000001];
    int result[1000001];
    int temp;

    cin >> str;

    int index = int(ceil(str.length() / 3.0)) - 1;
    int base = index;

    for(int i=0;i<str.length();++i)
        s[i] = str[i];

    for(int i=str.length()-1;i>=0;i-=3) {
        if(i >= 2) {
            temp = (s[i-2]-'0') * 4 +(s[i-1]-'0') * 2 + (s[i]-'0');
        } else if(i == 1) {
            temp = (s[i-1]-'0') * 2 + (s[i]-'0');
        } else if(i == 0) {
            temp = (s[i]-'0');
        }
        result[index--] = temp;
    }

    for(int i=0;i<=base;++i)
        cout << result[i];

    return 0;
}