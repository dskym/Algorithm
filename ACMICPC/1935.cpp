#include <iostream>
#include <stack>
#include <string>
#include <map>

using namespace std;

int main() {

    cout.setf(ios::fixed);

    string s;
    int n;
    map<char, double> m;

    cin >> n;

    cin >> s;

    for(int i=0;i<n;++i) {
        int temp;

        cin >> temp;

        m['A' + i] = temp;
    }

    stack<double> temp;

    double result = 0;

    for(int i=0;i<s.length();++i) {
        if(s[i] == '*') {
            double b = temp.top();
            temp.pop();

            double a = temp.top();
            temp.pop();

            temp.push(a * b);
        } else if (s[i] == '/') {
            double b = temp.top();
            temp.pop();

            double a = temp.top();
            temp.pop();

            temp.push(a / b);
        } else if (s[i] == '+') {
            double b = temp.top();
            temp.pop();

            double a = temp.top();
            temp.pop();

            temp.push(a + b);
        } else if (s[i] == '-') {
            double b = temp.top();
            temp.pop();

            double a = temp.top();
            temp.pop();

            temp.push(a - b);
        } else {
            temp.push(m[s[i]]);
        }
    }

    result = temp.top();

    cout.precision(2);
    cout << result << endl;

    return 0;
}