#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    string s;
    vector<string> v;

    cin >> s;

    int len = s.length();

    for(int i=1;i<len-2;++i) {
        for(int j=i+1;j<len;++j) {
            string a = s.substr(0, i);
            string b = s.substr(i, j-i);
            string c = s.substr(j);

            //cout << a << " " << b << " " << c << endl;

            reverse(a.begin(), a.end());
            reverse(b.begin(), b.end());
            reverse(c.begin(), c.end());

            v.push_back(a+b+c);
        }
    }

    sort(v.begin(), v.end());

    cout << v[0] << endl;

    return 0;
}