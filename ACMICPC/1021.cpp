#include <deque>
#include <iostream>

using namespace std;

int main() {
    int n, m;

    cin >> n >> m;

    int arr[51];

    for(int i=0;i<m;++i)
        cin >> arr[i];

    deque<int> dq;

    for(int i=1;i<=n;++i) {
        dq.push_back(i);
    }

    int result = 0;

    for(int i=0;i<m;++i) {
        int left = 0;

        for(int j=0;j<dq.size();++j) {
            if(arr[i] == dq[j])
                break;

            left++;
        }

        int right = dq.size()-left-1;

        if(left > right) {
            result += right + 1;

            for(int j=0;j<right;++j) {
                int temp = dq.back();

                dq.pop_back();
                dq.push_front(temp);
            }

            dq.pop_back();
        }
        else {
            result += left;        

            for(int j=0;j<left;++j) {
                int temp = dq.front();

                dq.pop_front();
                dq.push_back(temp);
            }

            dq.pop_front();
        }
    }

    cout << result << endl;

    return 0;
}