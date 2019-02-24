#include <iostream>

using namespace std;

int main() {
    int m, n;
    bool visited[1000001];

    for(int i=0;i<1000001;++i)
        visited[i] = true;

    visited[1] = false;

    for(int i=2;i<1001;++i) {
        if(visited[i] == false)
            continue;
        
        for(int j=i*i;j<1000001;j+=i) {
            visited[j] = false;
        }
    }

    cin >> m >> n;

    for(int i=m;i<=n;++i) {
        if(visited[i] == true)
            cout << i << '\n';
    }

    return 0;
}