class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        boolean[] travelDay = new boolean[lastDay + 1];

        for (int day : days)
            travelDay[day] = true;

        int[] dp = new int[lastDay + 1];
        dp[0] = 0;

        for (int i = 1; i <= lastDay; i++) {
            if (!travelDay[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = costs[0] + dp[i - 1];
            dp[i] = Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[i]);
            dp[i] = Math.min(dp[Math.max(0, i - 30)] + costs[2], dp[i]);
        }

        return dp[lastDay];
    }
}
