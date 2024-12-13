class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int[][] dp = new int[n][2];

        for(int i=0;i<n;++i) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0]-b[0]);

        long result = 0;
        for(int i=0;i<n;++i) {
            int score = dp[i][0];
            int index = dp[i][1];

            if(visited[index]) {
                continue;
            }

            result += score;

            visited[index] = true;
            if(index > 0) {
                visited[index-1] = true;
            }
            if(index < n-1) {
                visited[index+1] = true;
            }
        }
        return result;
    }
}
