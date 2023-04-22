class Solution {
    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        val dp = Array<IntArray>(1001) {IntArray(2001) {0}}
        val temp = Array<IntArray>(1001) {IntArray(2001) {0}}
        val n = piles.size

        for(i in 0 until piles.size) {
            for(j in 1..piles[i].size) {
                temp[i][j] = temp[i][j-1] + piles[i][j-1]
            }
        }

        var length = 0
        for(i in n-1 downTo 0) {
            length += piles[i].size
            for(j in 0..Math.min(k, length)) {
                for(l in 0..Math.min(j, piles[i].size)) {
                    dp[i][j] = maxOf(dp[i][j], dp[i+1][j-l] + temp[i][l])
                }
            }
        }

        return dp[0][k]
    }
}
