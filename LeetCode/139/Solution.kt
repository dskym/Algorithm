class Solution {
    val dp = IntArray(301)
    fun solve(index: Int, s: String, wordDict: List<String>): Boolean {
        if(s.length == 0) {
            return true
        }
        if(dp[index] == 0) {
            return false
        }
        for(word in wordDict) {
            if(s.startsWith(word)) {
                if(solve(index+word.length, s.substring(word.length), wordDict) == true) {
                    return true
                }
            }
        }
        dp[index] = 0
        return false
    }
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        dp.fill(-1)
        return solve(0, s, wordDict)
    }
}
