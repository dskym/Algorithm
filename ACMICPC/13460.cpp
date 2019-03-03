#include <iostream>
#include <queue>
#include <algorithm>
#include <memory.h>

using namespace std;

struct data {
    char map[11][11];
    int count;
};

int main() {
    int n, m;

    cin >> n >> m;

    char map[11][11];
    bool visited[11][11][11][11];
    queue<struct data> q;

    int rx, ry;
    int bx, by;
    int hx, hy;

    for(int i=0;i<n;++i) {
        for(int j=0;j<m;++j) {
            cin >> map[i][j];

            if(map[i][j] == 'R') {
                rx = i;
                ry = j;
            } else if(map[i][j] == 'B') {
                bx = i;
                by = j;
            } else if(map[i][j] == 'O') {
                hx = i;
                hy = j;
            }
        }
    }

    for(int a=0;a<11;++a) {
        for(int b=0;b<11;++b) {
            for(int c=0;c<11;++c) {
                for(int d=0;d<11;++d) {
                    visited[a][b][c][d] = false;
                }
            }
        }
    }

    struct data d;
    memcpy(d.map, map, sizeof(char)*11*11);
    d.count = 0;

    q.push(d);
    visited[rx][ry][bx][by] = true;

    int result = 20;

    while(!q.empty()) {
        struct data temp = q.front();
        q.pop();

        char temp_map[11][11];
        memcpy(temp_map, temp.map, sizeof(char)*11*11);
        int temp_count = temp.count;

        /*
        cout << temp_count << endl;
        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                cout << temp_map[i][j];
            }
            cout << endl;
        }
        */

        if(temp_count >= 10)
            break;

        int temp_rx, temp_ry, temp_bx, temp_by;

        for(int i=0;i<n;++i) {
            for(int j=0;j<m;++j) {
                if(temp_map[i][j] == 'R') {
                    temp_rx = i;
                    temp_ry = j;
                } else if(temp_map[i][j] == 'B') {
                    temp_bx = i;
                    temp_by = j;
                }
            }
        }

        char temp_data[11][11];
        memcpy(temp_data, temp_map, sizeof(char) * 11 * 11);

        bool flag = false;

        int change_rx, change_ry, change_bx, change_by;

        change_rx = temp_rx;
        change_ry = temp_ry;
        change_bx = temp_bx;
        change_by = temp_by;

        bool red = false;
        bool blue = false;

        //up
        if(temp_rx <= temp_bx) {
            //move red
            for(int i=temp_rx;i>=0;--i) {
                if(temp_data[i][temp_ry] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[i][temp_ry] == '#') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[i+1][temp_ry] = 'R';
                    change_rx = i+1;
                    break;
                }
            }

            //move blue
            for(int i=temp_bx;i>=0;--i) {
                if(temp_data[i][temp_by] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[i][temp_by] == '#' || temp_data[i][temp_by] == 'R') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[i+1][temp_by] = 'B';
                    change_bx = i+1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        } else if(temp_rx > temp_bx) {
            //move blue
            for(int i=temp_bx;i>=0;--i) {
                if(temp_data[i][temp_by] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[i][temp_by] == '#') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[i+1][temp_by] = 'B';
                    change_bx = i+1;
                    break;
                }
            }

            //move red
            for(int i=temp_rx;i>=0;--i) {
                if(temp_data[i][temp_ry] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[i][temp_ry] == '#' || temp_data[i][temp_ry] == 'B') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[i+1][temp_ry] = 'R';
                    change_rx = i+1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        }

        flag = false;

        change_rx = temp_rx;
        change_ry = temp_ry;
        change_bx = temp_bx;
        change_by = temp_by;

        red = false;
        blue = false;

        memcpy(temp_data, temp_map, sizeof(char) * 11 * 11);

        //down
        if(temp_rx >= temp_bx) {
            //move red
            for(int i=temp_rx;i<n;++i) {
                if(temp_data[i][temp_ry] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[i][temp_ry] == '#') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[i-1][temp_ry] = 'R';
                    change_rx = i-1;
                    break;
                }
            }

            //move blue
            for(int i=temp_bx;i<n;++i) {
                if(temp_data[i][temp_by] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[i][temp_by] == '#' || temp_data[i][temp_by] == 'R') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[i-1][temp_by] = 'B';
                    change_bx = i-1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        } else if(temp_rx < temp_bx) {
            //move blue
            for(int i=temp_bx;i<n;++i) {
                if(temp_data[i][temp_by] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[i][temp_by] == '#') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[i-1][temp_by] = 'B';
                    change_bx = i-1;
                    break;
                }
            }

            //move red
            for(int i=temp_rx;i<n;++i) {
                if(temp_data[i][temp_ry] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[i][temp_ry] == '#' || temp_data[i][temp_ry] == 'B') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[i-1][temp_ry] = 'R';
                    change_rx = i-1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        }

        flag = false;
        
        change_rx = temp_rx;
        change_ry = temp_ry;
        change_bx = temp_bx;
        change_by = temp_by;

        red = false;
        blue = false;

        memcpy(temp_data, temp_map, sizeof(char) * 11 * 11);

        //left
        if(temp_ry <= temp_by) {
            //move red
            for(int i=temp_ry;i>=0;--i) {
                if(temp_data[temp_rx][i] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[temp_rx][i] == '#') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[temp_rx][i+1] = 'R';
                    change_ry = i+1;
                    break;
                }
            }

            //move blue
            for(int i=temp_by;i>=0;--i) {
                if(temp_data[temp_bx][i] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[temp_bx][i] == '#' || temp_data[temp_bx][i] == 'R') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[temp_bx][i+1] = 'B';
                    change_by = i+1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        } else if(temp_ry > temp_by) {
            //move blue
            for(int i=temp_by;i>=0;--i) {
                if(temp_data[temp_bx][i] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[temp_bx][i] == '#') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[temp_bx][i+1] = 'B';
                    change_by = i+1;
                    break;
                }
            }

            //move red
            for(int i=temp_ry;i>=0;--i) {
                if(temp_data[temp_rx][i] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[temp_rx][i] == '#' || temp_data[temp_rx][i] == 'B') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[temp_rx][i+1] = 'R';
                    change_ry = i+1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        }

        flag = false;

        change_rx = temp_rx;
        change_ry = temp_ry;
        change_bx = temp_bx;
        change_by = temp_by;

        red = false;
        blue = false;

        memcpy(temp_data, temp_map, sizeof(char) * 11 * 11);

        //right
        if(temp_ry >= temp_by) {
            //move red
            for(int i=temp_ry;i<m;++i) {
                if(temp_data[temp_rx][i] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[temp_rx][i] == '#') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[temp_rx][i-1] = 'R';
                    change_ry = i-1;
                    break;
                }
            }

            //move blue
            for(int i=temp_by;i<m;++i) {
                if(temp_data[temp_bx][i] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[temp_bx][i] == '#' || temp_data[temp_bx][i] == 'R') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[temp_bx][i-1] = 'B';
                    change_by = i-1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        } else if(temp_ry < temp_by) {
            //move blue
            for(int i=temp_by;i<m;++i) {
                if(temp_data[temp_bx][i] == 'O') {
                    temp_data[temp_bx][temp_by] = '.';
                    blue = true;
                    break;
                } else if(temp_data[temp_bx][i] == '#') {
                    temp_data[temp_bx][temp_by] = '.';
                    temp_data[temp_bx][i-1] = 'B';
                    change_by = i-1;
                    break;
                }
            }

            //move red
            for(int i=temp_ry;i<m;++i) {
                if(temp_data[temp_rx][i] == 'O') {
                    temp_data[temp_rx][temp_ry] = '.';
                    red = true;
                    break;
                } else if(temp_data[temp_rx][i] == '#' || temp_data[temp_rx][i] == 'B') {
                    temp_data[temp_rx][temp_ry] = '.';
                    temp_data[temp_rx][i-1] = 'R';
                    change_ry = i-1;
                    break;
                }
            }

            if(red == true && blue == false)
                result = min(result, temp_count+1);

            flag = red || blue;

            if(visited[change_rx][change_ry][change_bx][change_by] == false && flag == false) {
                struct data push_data;
                memcpy(push_data.map, temp_data, sizeof(char) * 11 * 11);
                push_data.count = temp_count+1;

                q.push(push_data);
                visited[change_rx][change_ry][change_bx][change_by] = true;
            }
        }
    }

    if(result == 20)
        cout << -1 << endl;
    else
        cout << result << endl;

    return 0;
}