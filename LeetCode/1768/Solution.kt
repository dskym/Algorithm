class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        var ret = ""
        val index = Math.min(word1.length, word2.length) ?: 0
        for(i in 0 until index) {
            ret += word1[i]
            ret += word2[i]
        }
        for(i in index until word1.length) {
            ret += word1[i]
        }
        for(i in index until word2.length) {
            ret += word2[i]
        }
        return ret
    }
}
