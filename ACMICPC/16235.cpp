#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, m, k;

    cin >> n >> m >> k;

    int a[11][11];
    vector<int> tree[11][11];
    int c[11][11];
    int index[11][11];

    int pos[2][8] = {{1, 1, -1, -1, 0, 0, -1, 1},
                    {-1, 1, 1, -1, 1, -1, 0, 0}};

    for(int i=0;i<n;++i) {
        for(int j=0;j<n;++j) {
            cin >> a[i][j];

            c[i][j] = 5;
        }
    }

    for(int i=0;i<m;++i) {
        int x, y, z;

        cin >> x >> y >> z;

        tree[x-1][y-1].push_back(z);
    }

    for(int i=0;i<k;++i) {
        for(int x=0;x<n;++x) {
            for(int y=0;y<n;++y) {
                index[x][y] = -1;
            }
        }

        //spring
        for(int x=0;x<n;++x) {
            for(int y=0;y<n;++y) {
                sort(tree[x][y].begin(), tree[x][y].end());

                for(int z=0;z<tree[x][y].size();++z) {
                    if(tree[x][y][z] <= c[x][y]) {
                        c[x][y] -= tree[x][y][z];
                        tree[x][y][z]++;
                    } else {
                        index[x][y] = z;
                        break;
                    }
                }
            }
        }

        //summer
        for(int x=0;x<n;++x) {
            for(int y=0;y<n;++y) {
                if(index[x][y] == -1)
                    continue;

                for(int z=index[x][y];z<tree[x][y].size();++z) {
                    c[x][y] += tree[x][y][z] / 2;                    
                }

                int size = tree[x][y].size();

                for(int z=index[x][y];z<size;++z) {
                    tree[x][y].pop_back();
                }
            }
        }

        //fall
       for(int x=0;x<n;++x) {
            for(int y=0;y<n;++y) {
                for(int z=0;z<tree[x][y].size();++z) {
                    if(tree[x][y][z] % 5 == 0) {
                        for(int aa=0;aa<8;++aa) {
                            if(x + pos[0][aa] >= 0 && x + pos[0][aa] <= n-1 && y + pos[1][aa] >= 0 && y + pos[1][aa] <= n-1)
                                tree[x + pos[0][aa]][y + pos[1][aa]].push_back(1);
                        }
                    }
                }                
            }
        }

        //winter
       for(int x=0;x<n;++x) {
            for(int y=0;y<n;++y) {
                c[x][y] += a[x][y];
            }
        }
    }

    int result = 0;

    for(int x=0;x<n;++x) {
        for(int y=0;y<n;++y) {
            result += tree[x][y].size();
        }
    }

    cout << result << endl;

    return 0;
}