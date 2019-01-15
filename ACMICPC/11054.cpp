#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n;

    cin >> n;

    int arr[1001];

    int lis[1001];
    int lds[1001];

    for(int i=0;i<n;++i) {
        cin >> arr[i];
    }

    for(int i=0;i<1001;++i) {
        lis[i] = 1;
        lds[i] = 1;
    }

    for(int i=0;i<n;++i) {
        int maxLen = 1;

        for(int j=0;j<i;++j) {
            if(arr[i] > arr[j])
                maxLen = max(maxLen, lis[j] + 1);            
        }

        lis[i] = maxLen;
    }

    for(int i=n-1;i>=0;--i) {
        int maxLen = 1;

        for(int j=n-1;j>i;--j) {
            if(arr[i] > arr[j])
                maxLen = max(maxLen, lds[j] + 1);            
        }

        lds[i] = maxLen;
    }

    int result = 0;

    for(int i=0;i<n;++i) {
        //cout << lis[i] << " " << lds[i] << endl;
        result = max(result, lis[i] + lds[i] - 1);
    }

    cout << result << endl;

    return 0;
}