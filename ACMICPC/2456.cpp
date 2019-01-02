#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;

    cin >> n;

    int score[3];
    int count[3][3];
    //i+1이 j+1 점 받은 카운트

    for(int i=0;i<3;++i) {
        score[i] = 0;

        for(int j=0;j<3;++j) {
            count[i][j] = 0;
        }
    }

    for(int i=0;i<n;++i) {
        int a, b, c;

        cin >> a >> b >> c;

        score[0] += a;
        score[1] += b;
        score[2] += c;

        count[0][a-1] += 1;
        count[1][b-1] += 1;
        count[2][c-1] += 1;
    }

    int maxScore = 0;
    int maxIndex = 0;

    for(int i=0;i<3;++i) {
        if(maxScore < score[i]) {
            maxScore = score[i];
            maxIndex = i + 1;
        }
    }

    vector<int> samelist;

    for(int i=0;i<3;++i) {
        if(maxScore == score[i]) {
            samelist.push_back(i);
        }
    }

    if(samelist.size() == 1) {
        cout << maxIndex << " " << maxScore << endl;
    } else {
        int maxCount = count[samelist[0]][2];
        int maxCountIndex = samelist[0] + 1;

        for(int i=1;i<samelist.size();++i) {
            if(maxCount < count[samelist[i]][2]) {
                maxCount = count[samelist[i]][2];
                maxCountIndex = samelist[i] + 1;
            }
        }

        vector<int> anothersamelist;

        for(int i=0;i<samelist.size();++i) {
            if(maxCount == count[samelist[i]][2]) {
                anothersamelist.push_back(samelist[i]);
            }
        }

        if(anothersamelist.size() == 1) {
            cout << maxCountIndex << " " << maxScore << endl;
        } else {
            int maxCount = count[anothersamelist[0]][1];;
            int maxCountIndex = anothersamelist[0] + 1;

            for(int i=1;i<anothersamelist.size();++i) {
                if(maxCount < count[anothersamelist[i]][1]) {
                    maxCount = count[anothersamelist[i]][1];
                    maxCountIndex = anothersamelist[i] + 1;
                }
            }

            vector<int> finalsamelist;

            for(int i=0;i<anothersamelist.size();++i) {
                if(maxCount == count[anothersamelist[i]][1]) {
                    finalsamelist.push_back(anothersamelist[i]);
                }
            }

            if(finalsamelist.size() == 1) {
                cout << maxCountIndex << " " << maxScore << endl;
            } else {
                cout << 0 << " " << maxScore << endl;
            }
        }
    }

    return 0;
}