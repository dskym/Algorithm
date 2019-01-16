#include <iostream>

using namespace std;

int visited[15];
int n;

bool check(int x, int y) {
    //check column
    if(visited[y] != -1)
        return false;
        
    //check diagonal
    for(int i=0;i<n;++i) {
        if(visited[i] == -1)
            continue;
            
        if((x-y) == (visited[i]-i) || x+y == visited[i]+i)
            return false;
    }

    return true;
}

int solve(int row) {
    if(row == n)
        return 1;

    int result = 0;

    for(int i=0;i<n;++i) {
        if(check(row, i) == true) {
            //cout << row << ", " << i << endl;
            visited[i] = row;
            result += solve(row+1);
            visited[i] = -1;
        }
    }

    return result;
}

int main() {
    cin >> n;

    for(int i=0;i<n;++i)
        visited[i] = -1;

    int result = 0;

    result = solve(0);

    cout << result << endl;

    return 0;
}