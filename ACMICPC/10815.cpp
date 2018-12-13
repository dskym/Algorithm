/*
//Using binary search function.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    vector<int> v;

    int n;

    scanf("%d", &n);

    for(int i=0;i<n;++i) {
        int temp;

        scanf("%d", &temp);

        v.push_back(temp);
    }

    sort(v.begin(), v.end());

    int m;

    cin >> m;

    for(int i=0;i<m;++i) {
        int temp;

        scanf("%d", &temp);

        bool check = binary_search(
            v.begin(), v.end(), temp);

        if(check == true) {
            cout << 1 << " ";
        } else {
            cout << 0 << " ";
        }
    }

    cout << endl;

    return 0;
}
*/

/*
//Using set data structure.
#include <iostream>
#include <set>

using namespace std;

int main() {
    set<int> s;

    int n;

    scanf("%d", &n);

    for(int i=0;i<n;++i) {
        int temp;

        scanf("%d", &temp);

        s.insert(temp);
    }

    int m;

    cin >> m;

    for(int i=0;i<m;++i) {
        int temp;

        scanf("%d", &temp);

        auto p = s.find(temp);

        if(p != s.end()) {
            cout << 1 << " ";
        } else {
            cout << 0 << " ";
        }
    }

    return 0;
}
*/

//Implement binary search.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool search(vector<int>& v, int start, int end, int target) {
    int mid = (start + end) / 2;

    if(start > end)
        return false;

    if(v[mid] == target)
        return true;
    else if(v[mid] > target)
        return search(v, start, mid - 1, target);
    else
        return search(v, mid + 1, end, target);

    return false;
}

int main() {
    vector<int> v;

    int n;

    scanf("%d", &n);

    for(int i=0;i<n;++i) {
        int temp;

        scanf("%d", &temp);

        v.push_back(temp);
    }

    sort(v.begin(), v.end());

    int m;

    cin >> m;

    for(int i=0;i<m;++i) {
        int temp;

        scanf("%d", &temp);

        bool check = search(v, 0, v.size(), temp);

        if(check == true) {
            cout << 1 << " ";
        } else {
            cout << 0 << " ";
        }
    }

    cout << endl;

    return 0;
}
