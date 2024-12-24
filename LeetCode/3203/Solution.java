class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        Map<Integer, List<Integer>> g1 = build(edges1);
        Map<Integer, List<Integer>> g2 = build(edges2);

        Pair<Integer, Integer> p1 = maxHeight(0, g1);
        Pair<Integer, Integer> p2 = maxHeight(p1.getValue(), g1);

        Pair<Integer, Integer> p3 = maxHeight(0, g2);
        Pair<Integer, Integer> p4 = maxHeight(p3.getValue(), g2);

        int h1 = p2.getKey();
        int h2 = p4.getKey();
        int h3 = (int)Math.ceil(h1/2.0)+(int)Math.ceil(h2/2.0)+1;

        return Math.max(h1, Math.max(h2, h3));
    }

    private Map<Integer, List<Integer>> build(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int[] edge : edges) {
            List<Integer> l1 = g.getOrDefault(edge[0], new ArrayList<>());
            l1.add(edge[1]);
            g.put(edge[0], l1);

            List<Integer> l2 = g.getOrDefault(edge[1], new ArrayList<>());
            l2.add(edge[0]);
            g.put(edge[1], l2);
        }
        return g;
    }

    private Pair<Integer, Integer> maxHeight(int start, Map<Integer, List<Integer>> g) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.add(new Pair(start, 0));
        visited[start] = true;

        int height = 0;
        int node = start;

        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int n = p.getKey();
            int d = p.getValue();

            height = Math.max(d, height);
            node = n;

            if(g.get(n) != null) {
                for(int i=0;i<g.get(n).size();++i) {
                    int next = g.get(n).get(i);
                    if(visited[next] == false) {
                        q.add(new Pair(next, d+1));
                        visited[next] = true;
                    }
                }
            }
        }

        return new Pair(height, node);
    }
}
