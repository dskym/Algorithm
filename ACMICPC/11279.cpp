#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {

	int n;
	priority_queue<int> q;

    scanf("%d", &n);

	for (int i = 0; i < n; ++i) {
		int t;

        scanf("%d", &t);

		if (t == 0) {
			cout << (q.empty() ? 0 : q.top()) << '\n';

			if (!q.empty())
				q.pop();
		}
		else
			q.push(t);
	}

	return 0;
}