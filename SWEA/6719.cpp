#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int t;
    
    cin >> t;

    for(int i=0;i<t;++i) {
        int n, k;

        cin >> n >> k;

        vector<int> m;

        for(int j=0;j<n;++j) {
            int temp;

            cin >> temp;

            m.push_back(temp);
        }

        sort(m.begin(), m.end());
        
        double result = 0;

        for(int j=n-k;j<n;++j) {
            result = (result + m[j]) / 2.0;
        }

        cout << "#" << i+1 << " " << result << endl;
    }

    return 0;
}