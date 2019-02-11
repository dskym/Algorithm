#include <iostream>

using namespace std;

int n;
bool visited[101];
int g[101];

bool dfs(int start, int curr) {
    if(start == curr)
        return true;

    if(visited[curr] == false) {
        visited[curr] = true;

        if(dfs(start, g[curr]) == true)
            return true;

        visited[curr] = false;
    }

    return false;
}

int main() {
    cin >> n;

    for(int i=0;i<n;++i) {
        int t;

        cin >> t;

        g[i] = t-1;
    }

    for(int i=0;i<n;++i) {
        if(visited[i] == false) {
            visited[i] = true;

            if(dfs(i, g[i]) == true)
                continue;

            visited[i] = false;
        }
    }

    int result = 0;

    for(int i=0;i<n;++i) {
        if(visited[i] == true) {
            result++;
        }
    }
    
    cout << result << endl;

    for(int i=0;i<n;++i) {
        if(visited[i] == true) {
            cout << i+1 << endl;
        }
    }

    return 0;
}