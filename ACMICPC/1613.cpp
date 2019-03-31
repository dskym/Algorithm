#include<iostream>
#include<algorithm>

using namespace std;

int main()
{
	int g[401][401];
	
	int n, m;

	scanf("%d %d", &n, &m);
	//cin >> n >> m;

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

		scanf("%d %d", &a, &b);
		//cin >> a >> b;

		g[a - 1][b - 1] = 1;
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			for (int k = 0; k < n; ++k) {
				g[j][k] = min(g[j][k], g[j][i] + g[i][k]);
			}
		}
	}

	int s;

	scanf("%d", &s);
	//cin >> s;

	for (int i = 0; i < s; ++i) {
		int a, b;

		scanf("%d %d", &a, &b);
		//cin >> a >> b;

		if (g[a - 1][b - 1] != 1000)
			printf("%d\n", -1);
		else if (g[b - 1][a - 1] != 1000)
			printf("%d\n", 1);
		else
			printf("%d\n", 0);
	}

	return 0;
}
