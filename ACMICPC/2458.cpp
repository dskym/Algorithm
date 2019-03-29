#include<iostream>
#include<algorithm>

using namespace std;

int main()
{
	int g[501][501];
	
	int n, m;

	cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (i == j)
				g[i][j] = 0;
			else
				g[i][j] = 1000;
		}
	}

	for (int i = 0; i < m; ++i) {
		int a, b;

		cin >> a >> b;

		g[a - 1][b - 1] = 1;
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			for (int k = 0; k < n; ++k) {
				g[j][k] = min(g[j][k], g[j][i] + g[i][k]);
			}
		}
	}

	int result = 0;

	for (int i = 0; i < n; ++i) {
		bool visited[501];
		bool flag = true;

		for (int j = 0; j < n; ++j)
			visited[j] = false;

		for (int j = 0; j < n; ++j) {
			if (g[i][j] != 1000 || g[j][i] != 1000)
				visited[j] = true;
		}

		for (int j = 0; j < n; ++j)
			if (visited[j] == false)
				flag = false;

		if (flag == true)
			result++;
	}

	cout << result << endl;

	return 0;
}
