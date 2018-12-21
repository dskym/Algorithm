#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    int n, m;

    scanf("%d %d", &n, &m);

    map<string, string> dicByName;
    string dicByNum[100001];

    for(int i=0;i<n;++i) {
        char temp[100001];

        scanf("%s", temp);

        string name = string(temp);

        dicByName.insert(make_pair(name, to_string(i+1)));
        dicByNum[i+1] = name;
    }

    for(int i=0;i<m;++i) {
        char temp[100001];

        scanf("%s", temp);

        string prob = string(temp);

        if(prob[0] >= '0' && prob[0] <= '9')
            printf("%s\n", dicByNum[stoi(prob)].c_str());
        else
            printf("%s\n", dicByName[prob].c_str());
    }

    return 0;
}