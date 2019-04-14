#include <iostream>

using namespace std;

void solve(int* arr, int start, int end, int depth, int height) {        
    int mid = (start + end) / 2;

    if(height == depth) {
        cout << arr[mid] << " ";
    }

    if(start == end)
        return;

    solve(arr, start, mid - 1, depth + 1, height);
    solve(arr, mid + 1, end, depth + 1, height);
}

int main() {
    int k;

    cin >> k;

    int arr[1024];

    for(int i=0;i<(1<<k) - 1;++i)
        cin >> arr[i];

    for(int i=0;i<k;++i) {
        solve(arr, 0, (1<<k) - 2, 0, i);
        cout << endl;
    }

    return 0;
}