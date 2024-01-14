class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if(word1.length != word2.length) {
            return false
        }

        val m1 = word1.groupingBy { it }.eachCount()
        val m2 = word2.groupingBy { it }.eachCount()

        val k1 = m1.keys.toList().sorted()
        val k2 = m2.keys.toList().sorted()

        val v1 = m1.values.toList().sorted()
        val v2 = m2.values.toList().sorted()

        if(k1 != k2) {
            return false
        }

        if(v1 != v2) {
            return false
        }

        return true
    }
}

