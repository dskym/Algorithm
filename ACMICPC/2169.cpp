#include <iostream>
#include <algorithm>

using namespace std;

int main() {

    int** ldp;
    int** rdp;
    int** result;
    int** v;
    int n, m;

    cin >> n >> m;

    ldp = new int*[n];
    rdp = new int*[n];
    result = new int*[n];
    v = new int*[n];

    for(int i=0;i<n;++i) {
        ldp[i] = new int[m];
        rdp[i] = new int[m];
        result[i] = new int[m];
        v[i] = new int[m];
    }

    for(int i=0;i<n;++i)
        for(int j=0;j<m;++j)
            cin >> v[i][j];

    ldp[0][0] = v[0][0];
    rdp[0][0] = v[0][0];
    result[0][0] = v[0][0];

    for(int i=1;i<m;++i) {
        ldp[0][i] = v[0][i] + ldp[0][i-1];
        rdp[0][i] = v[0][i] + rdp[0][i-1];

        result[0][i] = v[0][i] + result[0][i-1];
    }

    for(int i=1;i<n;++i) {
        for(int j=0;j<m;++j) {
            if(j == 0) {
                ldp[i][j] = result[i-1][j] + v[i][j];
            }
            else {
                ldp[i][j] = max(ldp[i][j-1], result[i-1][j]) + v[i][j];
            }
        }

        for(int j=m-1;j>=0;--j) {
            if(j == m-1) {
                rdp[i][j] = result[i-1][j] + v[i][j];
            }
            else {
                rdp[i][j] = max(rdp[i][j+1], result[i-1][j]) + v[i][j];
            }
        }

        for(int j=0;j<m;++j)
            result[i][j] = max(ldp[i][j], rdp[i][j]);
    }

    cout << result[n-1][m-1] << endl;

    return 0;
}
