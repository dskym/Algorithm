class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> set = new HashSet<>();
        for(int r : restricted) {
            set.add(r);
        }

        int[] parent = new int[n];
        int[] size = new int[n];

        for(int i=0;i<n;++i) {
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges) {
            if(set.contains(edge[0]) || set.contains(edge[1])) {
                continue;
            }

            union(parent, size, edge[0], edge[1]);
        }
        return size[0];
    }

    private void union(int[] parent, int[] size, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if(pa < pb) {
            parent[pb] = pa;
            size[pa] += size[pb];
        } else {
            parent[pa] = pb;
            size[pb] += size[pa];
        }
    }

    private int find(int[] parent, int a) {
        if(parent[a] == a) {
            return parent[a];
        }
        parent[a] = find(parent, parent[a]);
        return parent[a];
    }
}
