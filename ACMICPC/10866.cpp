#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;

    cin >> n;

    int deque[100001];
    int left = 0;
    int right = 1;
    int size = 0;

    for(int i=0;i<n;++i) {
        string op;

        cin >> op;

        if(!op.compare("push_front")) {
            int temp;

            cin >> temp;

            deque[left] = temp;

            if(left == 0)
                left = 100000;
            else
                left--;            

            size++;
        } else if(!op.compare("push_back")) {
            int temp;

            cin >> temp;

            deque[right] = temp;

            if(right == 100000)
                right = 0;
            else
                right++;

            size++;            
        } else if(!op.compare("pop_front")) {
            if(size > 0) {
                if(left == 100000) {
                    left = 0;
                } else {
                    left++;
                }
            
                int temp = deque[left];

                cout << temp << '\n';

                size--;
            } else {
                cout << -1 << '\n';
            }
        } else if(!op.compare("pop_back")) {
            if(size > 0) {
                if(right == 0) {
                    right = 100000;
                } else {
                    right--;
                }

                int temp = deque[right];

                cout << temp << '\n';

                size--;
            } else {
                cout << -1 << '\n';
            }
        } else if(!op.compare("size")) {
            cout << size << endl;
        } else if(!op.compare("empty")) {
            if(size != 0)
                cout << 0 << endl;
            else
                cout << 1 << endl;
        } else if(!op.compare("front")) {
            if(size != 0) {
                if(left == 100000) {
                    int temp = deque[0];

                    cout << temp << '\n';
                } else {
                    int temp = deque[left+1];

                    cout << temp << '\n';
                }
            } else {
                cout << -1 << '\n';
            }
        } else if(!op.compare("back")) {
            if(size != 0) {
                if(right == 0) {
                    int temp = deque[100000];

                    cout << temp << '\n';
                } else {
                    int temp = deque[right-1];

                    cout << temp << '\n';
                }
            } else {
                cout << -1 << '\n';
            }
        }
    }

    return 0;
}

/*
#include <iostream>
#include <deque>
#include <string>

using namespace std;

int main() {
    int n;

    cin >> n;

    deque<int> dq;

    for(int i=0;i<n;++i) {
        string op;

        cin >> op;

        if(!op.compare("push_front")) {
            int temp;

            cin >> temp;

            dq.push_front(temp);
        } else if(!op.compare("push_back")) {
            int temp;

            cin >> temp;

            dq.push_back(temp);
        } else if(!op.compare("pop_front")) {
            if(!dq.empty()) {
                int temp = dq.front();

                cout << temp << '\n';

                dq.pop_front();
            } else {
                cout << -1 << '\n';
            }
        } else if(!op.compare("pop_back")) {
            if(!dq.empty()) {
                int temp = dq.back();

                cout << temp << '\n';

                dq.pop_back();
            } else {
                cout << -1 << '\n';
            }
        } else if(!op.compare("size")) {
            cout << dq.size() << '\n';
        } else if(!op.compare("empty")) {
            cout << dq.empty() << '\n';
        } else if(!op.compare("front")) {
            if(!dq.empty()) {
                int temp = dq.front();

                cout << temp << '\n';
            } else {
                cout << -1 << '\n';
            }
        } else if(!op.compare("back")) {
            if(!dq.empty()) {
                int temp = dq.back();

                cout << temp << '\n';
            } else {
                cout << -1 << '\n';
            }
        }
    }

    return 0;
}
*/