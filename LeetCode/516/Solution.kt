class Solution {
    val dp = Array<IntArray>(1001) {IntArray(1001){-1}}
    fun longestPalindromeSubseq(s: String): Int {
        return palindrome(s, 0, s.length-1)
    }

    fun palindrome(s: String, left: Int, right: Int): Int{
        if(dp[left][right] != -1) {
            return dp[left][right]
        }
        if(left > right) {
            dp[left][right] = 0
            return dp[left][right]
        }

        if(left == right) {
            dp[left][right] = 1
            return dp[left][right]
        }

        if(s[left] == s[right]) {
            dp[left][right] = palindrome(s, left+1, right-1) + 2
        } else {
            dp[left][right] = Math.max(palindrome(s, left+1, right), palindrome(s, left, right-1))
        }
        return dp[left][right]
    }
}
