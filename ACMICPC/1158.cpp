#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, m;
    bool visited[5001];
    int num[5001];
    vector<int> v;

    cin >> n >> m;

    int counter = m;
    int index = 0;

    for(int i=0;i<n;++i) {
        visited[i] = false;
        num[i] = i;
    }

    num[0] = n;

    while(v.size() != n) {
        counter = m;

        while(counter != 0) {
            counter--;
            index++;

            if(index >= n)
                index -= n;

            if(visited[index] == true)
                counter++;
        }
        
        visited[index] = true;
        v.push_back(num[index]);
    }

    cout << "<";

    for(int i=0;i<v.size();++i) {
        cout << v[i];

        if(i != v.size()-1)
            cout << ", ";
    }

    cout << ">" << endl;

    return 0;
}