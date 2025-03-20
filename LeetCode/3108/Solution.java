class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] value = new int[n];

        for(int i=0;i<n;++i) {
            parent[i] = i;
            value[i] = Integer.MAX_VALUE;
        }

        for(int[] edge : edges) {
            union(edge[0], edge[1], parent, value, edge[2]);
        }

        int m = query.length;
        int[] result = new int[m];
        for(int i=0;i<m;++i) {
            int pa = find(query[i][0], parent);
            int pb = find(query[i][1], parent);

            if(pa != pb) {
                result[i] = -1;
            } else {
                result[i] = value[pa];
            }
        }
        return result;
    }

    private void union(int a, int b, int[] parent, int[] value, int weight) {
        int pa = find(a, parent);
        int pb = find(b, parent);

        if(pa != pb) {
            value[pa] = value[pa] & value[pb] & weight;
            value[pb] = value[pa];
            parent[pb] = pa;
        } else {
            value[pa] = value[pa] & weight;
        }
    }

    private int find(int a, int[] parent) {
        if(a == parent[a]) {
            return a;
        }
        
        int pa = find(parent[a], parent);
        parent[a] = pa;
        return pa;
    }
}

