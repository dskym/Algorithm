#include <iostream>
#include <vector>

using namespace std;

int main() {
    bool prime[10001];
    vector<int> p;

    for(int i=0;i<10001;++i)
        prime[i] = true;

    prime[0] = false;
    prime[1] = false;

    for(int i=2;i<=10000;++i) {
        if(prime[i] == false)
            continue;

        for(int j=i*i;j<=10000;j+=i) {
            prime[j] = false;            
        }
    }

    for(int i=2;i<=10000;++i) {
        if(prime[i] == true) {
            p.push_back(i);
        }
    }

    int t;

    cin >> t;

    for(int i=0;i<t;++i) {
        int n;

        cin >> n;

        int a, b;
        int diff = -1;

        for(int j=0;j<p.size();++j) {
            if(prime[n-p[j]] == true) {
                if(diff == -1) {
                    a = p[j];
                    b = n-p[j];

                    diff = abs(a-b);
                } else {
                    if(diff > abs(p[j]-n+p[j]) && p[j] <= n-p[j]){
                        a = p[j];
                        b = n-p[j];
                    }
                }
            }
        }

        cout << a << " " << b << endl;
    }

    return 0;
}