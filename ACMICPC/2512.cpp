#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    vector<int> v;
    int left = 1;
    int right = 100000;    

    int sum = 0;

    cin >> n;

    for(int i=0;i<n;++i) {
        int temp;

        cin >> temp;

        v.push_back(temp);

        sum += temp;
    }

    int asset;
    int result = 0;
    cin >> asset;

    if(sum <= asset) {
        for(int i=0;i<v.size();++i) {
            result = max(result, v[i]);
        }
    } else {
        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            //cout << left << " " << mid << " " << right << endl;

            for(int i=0;i<v.size();++i) {
                sum += min(v[i], mid);
            }

            if(sum > asset)
                right = mid-1;
            else if(sum <= asset) {
                left = mid+1;
                result = max(result, mid);
            }
        }
    }

    cout << result << endl;

    return 0;
}