class Solution {
    private int[] parent;

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) {
            return -1;
        }

        parent = new int[n];
        for(int i=0;i<n;++i) {
            parent[i] = i;
        }

        for(int[] connection : connections) {
            union(connection[0], connection[1]);
        }

        int count = 0;
        for(int i=0;i<n;++i) {
            if(parent[i] == i) {
                count++;
            }
        }
        return count-1;
    }

    private int find(int node) {
        if(parent[node] == node) {
            return node;
        }
        return find(parent[node]);
    }

    private void union(int nodeA, int nodeB) {
        int parentA = find(nodeA);
        int parentB = find(nodeB);

        if(parentA == parentB) {
            return;
        }

        parent[parentA] = parentB;
    }
}
