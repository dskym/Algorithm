class Solution {
    fun isPalindrome(s: String): Boolean {
        val c = s.lowercase().filter { it in 'a'..'z' || it in '0'..'9'}.toList()
        for(i in 0 until c.size/2) {
            if(c[i] != c[c.size-i-1]) {
                return false
            }
        }
        return true
    }
}
