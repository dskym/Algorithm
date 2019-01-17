#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    
    cin >> n;

    int arr[101];

    for(int i=0;i<n;++i)
        cin >> arr[i];

    unsigned long long int  left[101][21];
    unsigned long long int  right[101][21];

    for(int i=0;i<101;++i) {
        for(int j=0;j<21;++j) {
            left[i][j] = 0;
            right[i][j] = 0;
        }
    }

    left[0][arr[0]] = 1;

    for(int i=1;i<n;++i) {
        for(int j=0;j<=20;++j) {
            if(left[i-1][j] != 0) {
                if(0 <= j+arr[i] && j+arr[i] <= 20)
                    left[i][j+arr[i]] += left[i-1][j];

                if(0 <= j-arr[i] && j-arr[i] <= 20)
                    left[i][j-arr[i]] += left[i-1][j];
            }
        }
    }

    /*
    for(int i=0;i<n;++i) {
        for(int j=0;j<=20;++j) {
            cout << left[i][j] << " ";
        }
        cout << endl;
    }

    cout << endl;
    */

    cout << left[n-2][arr[n-1]] << endl;

   /*
    right[n-1][arr[n-1]] = 1;

    for(int i=n-2;i>=0;--i) {
        for(int j=0;j<=20;++j) {
            if(right[i+1][j] != 0) {
                if(0 <= j+arr[i] && j+arr[i] <= 20)
                    right[i][j+arr[i]] += right[i+1][j];

                if(0 <= j-arr[i] && j-arr[i] <= 20)
                    right[i][j-arr[i]] += right[i+1][j];
            }
        }
    }
    */

    /*
    for(int i=0;i<n;++i) {
        for(int j=0;j<=20;++j) {
            cout << right[i][j] << " ";
        }
        cout << endl;
    }
    */

    /*
    unsigned long long int result = 0;

    for(int i=0;i<n-1;++i) {
        for(int j=0;j<=20;++j) {
            if(left[i][j] != 0 && right[i+1][j] != 0) {
                //cout << i << " " << j << endl;
                result += left[i][j] * right[i+1][j];
            }
        }
    }

    cout << result << endl;      
    */

    return 0;
}