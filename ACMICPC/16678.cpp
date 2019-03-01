#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;

    cin >> n;

    vector<int> v;

    for(int i=0;i<n;++i) {
        int t;

        cin >> t;

        v.push_back(t);
    }

    sort(v.begin(), v.end());

    unsigned long long int result = 0;
    int base = 1;

    for(int i=0;i<n;++i) {
        if(v[i] >= base) {
            result += (v[i] - base);
            base++;
         }
    }

    cout << result << endl;

    return 0;
}