class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegrees = new int[n+1];
        for(int[] edge : edges) {
            indegrees[edge[1]]++;
        }

        int count = 0;
        int node = 0;
        for(int i=0;i<n;++i) {
            if(indegrees[i] == 0) {
                count++;
                node = i;
            }
        }

        if(count == 1) {
            return node;
        } else {
            return -1;
        }
    }
}
