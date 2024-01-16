class Solution {
    fun halvesAreAlike(s: String): Boolean {
        val a = s.substring(0, s.length / 2).toLowerCase().count { it in listOf('a', 'e', 'i', 'o', 'u') }
        val b = s.substring(s.length / 2, s.length).toLowerCase().count { it in listOf('a', 'e', 'i', 'o', 'u') }
        return a == b
    }
}
