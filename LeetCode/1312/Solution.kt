class Solution {
    val dp = Array<IntArray>(501){IntArray(501){Int.MAX_VALUE}}
    fun minInsertions(s: String): Int {
        return solve(s, 0, s.length-1)
    }
    fun solve(s: String, left: Int, right :Int): Int {
        if(left > right || right >= s.length) {
            return 0
        }

        if(dp[left][right] != Int.MAX_VALUE) {
            return dp[left][right]
        }

        if(s[left] == s[right]) {
            dp[left][right] = solve(s, left+1, right-1)
            return dp[left][right]
        }

        val l = solve(s, left+1, right) + 1
        val r = solve(s, left, right-1) + 1
        dp[left][right] = Math.min(l, r)

        return dp[left][right]
    }
}
