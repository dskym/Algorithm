class Solution {
    fun lengthOfLastWord(s: String): Int {
        return s.split(' ').filter { it.isNotBlank() }.last().length
    }
}
