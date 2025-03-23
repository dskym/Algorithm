class Solution {
    public int countPaths(int n, int[][] roads) {
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);

        int[] count = new int[n];

        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;++i) {
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads) {
            graph.get(road[0]).add(new int[]{road[1], road[2]});
            graph.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        q.add(new long[]{0,0});
        dp[0] = 0;
        count[0] = 1;

        while(!q.isEmpty()) {
            long[] node = q.poll();
            long time = node[0];
            int curr = (int)node[1];

            if(time > dp[curr]) {
                continue;
            }

            for(int[] nextNode : graph.get(curr)) {
                int next = nextNode[0];
                int dist = nextNode[1];

                if(time + dist == dp[next]) {
                    count[next] = (count[next] + count[curr]) % 1000000007;
                } else if(time + dist < dp[next]) {
                    dp[next] = time + dist;
                    count[next] = count[curr] % 1000000007;
                    q.add(new long[]{dp[next], next});
                }
            }
        }

        return count[n-1];
    }
}
