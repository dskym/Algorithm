class Solution {
    private int[] parent;
    private int[] landSize;

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] direct = {{0,1},{0,-1},{1,0},{-1,0}};

        // initialize
        parent = new int[n*n];
        landSize = new int[n*n];
        for(int i=0;i<n*n;++i) {
            parent[i] = i;
            landSize[i] = 1;
        }

        boolean flag = true;
        
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(grid[i][j] == 1) {
                    int node = i*n+j;
                    for(int k=0;k<4;++k) {
                        int di = i+direct[k][0];
                        int dj = j+direct[k][1];
                        if(di >= 0 && di < n && dj >= 0 && dj < n && grid[di][dj] == 1) {
                            int dnode = di*n+dj;
                            union(node, dnode);
                        }
                    }
                } else {
                    flag = false;
                }
            }
        }

        if(flag) {
            return n*n;
        }

        int result = 0;
        for(int i=0;i<n;++i) {
            for(int j=0;j<n;++j) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    int nodeSize = 1;
                    for(int k=0;k<4;++k) {
                        int di = i+direct[k][0];
                        int dj = j+direct[k][1];
                        if(di >= 0 && di < n && dj >= 0 && dj < n && grid[di][dj] == 1) {
                            int dnode = di*n+dj;
                            int root = find(dnode);
                            set.add(root);
                        }
                    }

                    for(int root : set) {
                        nodeSize += landSize[root];
                    }

                    result = Math.max(result, nodeSize);
                }
            }
        }
        return result;
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

        if(rootA == rootB) {
            return;
        }

        if(landSize[rootA] < landSize[rootB]) {
            parent[rootA] = rootB;
            landSize[rootB] += landSize[rootA];
        } else {
            parent[rootB] = rootA;
            landSize[rootA] += landSize[rootB];
        }
    }
}
