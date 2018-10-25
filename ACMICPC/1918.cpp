#include <iostream>
#include <stack>
#include <string>

using namespace std;

int main() {

    string s;

    cin >> s;

    stack<char> temp;

    string result = "";

    for(int i=0;i<s.length();++i) {
        if(s[i] == ')') {
            while(!temp.empty()) {
                char c = temp.top();
                temp.pop();

                if(c == '(')
                    break;

                result += c;
            }
        } else if(s[i] == '(') {
            temp.push(s[i]);
        } else if(s[i] == '+' || s[i] == '-') {
            while(!temp.empty()) {
                char c = temp.top();

                if(c == '(')
                    break;

                temp.pop();

                result += c;
            }
            temp.push(s[i]);
        } else if(s[i] == '*' || s[i] == '/') {
            while(!temp.empty()) {
                char c = temp.top();

                if(c == '+' || c == '-' || c == '(')
                    break;

                temp.pop();

                result += c;
            }
            temp.push(s[i]);
        } else {
            result += s[i];
        }
    }

    while(!temp.empty()) {
        char c = temp.top();
        temp.pop();

        result += c;
    } 

    cout << result << endl;

    return 0;
}