#include <iostream>
#include <stack>

using namespace std;

int main() {
    int n;

    cin >> n;

    stack<char> s;

    for(int i=0;i<n;++i) {
        char c;

        cin >> c;

        s.push(c);
    }

    while(s.size() != 1) {
        char a = s.top();
        s.pop();

        char b = s.top();
        s.pop();

        if(b == 'A' && a == 'A')
            s.push('A');
        else if(b == 'A' && a == 'G')
            s.push('C');
        else if(b == 'A' && a == 'C')
            s.push('A');
        else if(b == 'A' && a == 'T')
            s.push('G');

        else if(b == 'G' && a == 'A')
            s.push('C');
        else if(b == 'G' && a == 'G')
            s.push('G');
        else if(b == 'G' && a == 'C')
            s.push('T');
        else if(b == 'G' && a == 'T')
            s.push('A');

        else if(b == 'C' && a == 'A')
            s.push('A');
        else if(b == 'C' && a == 'G')
            s.push('T');
        else if(b == 'C' && a == 'C')
            s.push('C');
        else if(b == 'C' && a == 'T')
            s.push('G');

        else if(b == 'T' && a == 'A')
            s.push('G');
        else if(b == 'T' && a == 'G')
            s.push('A');
        else if(b == 'T' && a == 'C')
            s.push('G');
        else if(b == 'T' && a == 'T')
            s.push('T');
    }

    cout << s.top() << endl;

    return 0;
}