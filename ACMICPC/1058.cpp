#include <iostream>

using namespace std;

int main() {
    int n;

    char g[51][51];
    char result[51][51];

    cin >> n;

    for(int i=0;i<n;++i)
        for(int j=0;j<n;++j)
            cin >> g[i][j];

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            if(g[i][j] == 'N' && i != j) {
                for(int k=0;k<n;++k) {
                    if(g[j][k] == 'Y' && g[i][k] == 'Y') {
                        result[i][j] = 'Y';
                        break;
                    } else {
                        result[i][j] = g[i][j];
                    }
                }
            } else {
                result[i][j] = g[i][j];
            }
        }
    }

    int output = 0;

    for(int i=0;i<n;++i) {
        int  temp = 0;
        
        for(int j=0;j<n;++j) {
            if(result[i][j] == 'Y')
            temp++;
        }

        output = max(output, temp);
    }

    cout << output << endl;

    return 0;
}