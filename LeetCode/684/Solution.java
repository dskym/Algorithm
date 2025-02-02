class Solution {
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i=1;i<=n;++i) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int parentA = find(edge[0]);
            int parentB = find(edge[1]);

            if(parentA == parentB) {
                return edge;
            }

            union(parentA, parentB);
        }

        return new int[2];
    }

    private int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return find(parent[node]);
    }

    private void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);

        if(rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }
}
