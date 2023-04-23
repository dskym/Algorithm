class Solution {
    val dp = Array(101){Array(101){IntArray(101){0}}}
    fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
        val m = group.size

        dp[0][0][0] = 1
        for(i in 1..m) {
            for(j in 0..n) {
                for(k in 0..minProfit) {
                    if(j-group[i-1] < 0) {
                        dp[i][j][k] = dp[i-1][j][k];
                    } else {
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-group[i-1]][Math.max(0, k-profit[i-1])]) % 1000000007
                    }
                }
            }
        }

        var ret = 0
        for(i in 0..n) {
            ret = (ret + dp[m][i][minProfit]) % 1000000007
        }
        return ret
    }
}
