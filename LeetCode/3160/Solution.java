class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> ball = new HashMap<>();
        Map<Integer, Integer> counter = new HashMap<>();

        int[] result = new int[n];
        for(int i=0;i<n;++i) {
            if(ball.containsKey(queries[i][0]) == false) {
                ball.put(queries[i][0], queries[i][1]);
                counter.compute(queries[i][1], (k, v) -> (v == null) ? 1 : v + 1);
            } else {
                counter.compute(ball.get(queries[i][0]), (k, v) -> (v == null) ? 1 : v - 1);
                if(counter.get(ball.get(queries[i][0])) == 0) {
                    counter.remove(ball.get(queries[i][0]));
                }
                counter.compute(queries[i][1], (k, v) -> (v == null) ? 1 : v + 1);
                ball.put(queries[i][0], queries[i][1]);
            }
            result[i] = counter.size();
        }
        return result;
    }
}
