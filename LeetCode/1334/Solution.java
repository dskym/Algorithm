class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] count = new int[n];

        int[][] graph = new int[n][n];
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(i == j) {
                    continue;
                }
                graph[i][j] = 999999999;
            }
        }

        for(int i=0;i<edges.length;++i) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for(int k=0;k<n;++k) {
            for(int i=0;i<n;++i) {
                for(int j=0;j<n;++j) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for(int i=0;i<n;++i) {
            int cnt = 0;
            for(int j=0;j<n;++j) {
                if(graph[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            count[i] = cnt;
        }

        int result = n-1;
        int temp = count[n-1];
        for(int i=n-2;i>=0;--i) {
            if(temp > count[i]) {
                temp = count[i];
                result = i;
            }
        }
        return result;
    }
}

