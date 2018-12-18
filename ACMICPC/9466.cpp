#include <iostream>

using namespace std;

bool solve(int start, int next, int* student, bool* visited, bool* disabled) {
    if(disabled[next] == true)
        return false;

    if(start == next) {
         return true;
    }

    if(visited[next] == true) {
        return false;
    }
    
    visited[next] = true;

    if(solve(start, student[next] - 1, student, visited, disabled) == true)
        return true;

    visited[next] = false;

    return false;
}

int main() {
    int t;

    cin >> t;

    for(int i=0;i<t;++i) {
        int n;

        cin >> n;

        int student[100001];
        bool visited[100001];
        bool disabled[100001];

        for(int j=0;j<n;++j) {
            cin >> student[j];
        }

        for(int j=0;j<n;++j) {
            visited[j] = false;
            disabled[j] = false;
        }

        for(int i=0;i<n;++i) {
            if(visited[i] == false) {
                visited[i] = true;

                if(solve(i, student[i] - 1, student, visited, disabled) == false) {
                    disabled[i] = true;
                    visited[i] = false;
                }
            }
        }

        int result = 0;

        for(int i=0;i<n;++i) {
            if(visited[i] == false) {
                result++;
            }
        }

        cout << result << '\n';
    }

    return 0;
}