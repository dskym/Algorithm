class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degrees = new int[n];
        for(int i=0;i<roads.length;++i) {
            degrees[roads[i][0]]++;
            degrees[roads[i][1]]++;
        }

        Integer[] nodes = new Integer[n];
        for(int i=0;i<n;++i) {
            nodes[i] = i;
        }

        Arrays.sort(nodes, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(degrees[b], degrees[a]);
            }
        });

        long result = 0;
        for(int i=0;i<n;++i) {
            result = result + (long)degrees[nodes[i]] * (n-i);
        }
        return result;
    }
}
