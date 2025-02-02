class Solution {
    private int[] parent;
    private int[] nodeCount;
    private int[] edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        nodeCount = new int[n];
        edgeCount = new int[n];

        for(int i=0;i<n;++i) {
            parent[i] = -1;
            nodeCount[i] = 1;
            edgeCount[i] = 0;
        }

        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        int result = 0;
        for(int i=0;i<n;++i) {
            if(parent[i] == -1 && nodeCount[i]*(nodeCount[i]-1) == edgeCount[i]*2) {
                result++;
            }
        }
        return result;
    }

    private int find(int node) {
        if(parent[node] == -1) {
            return node;
        }
        return find(parent[node]);
    }

    private void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);

        edgeCount[rootA]++;

        if(rootA == rootB) {
            return;
        }

        parent[rootB] = rootA;
        edgeCount[rootA]+=edgeCount[rootB];
        nodeCount[rootA]+=nodeCount[rootB];
    }
}
