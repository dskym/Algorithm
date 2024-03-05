class Solution {
    fun minimumLength(s: String): Int {
        var start = 0
        var end = s.length-1

        while(start < end) {
            val c = s[start]
            if(s[start] != s[end]) {
                break
            }
            while(s[++start] == c) {
                if(start >= end) {
                    break
                }
            }
            while(s[--end] == c) {
                if(start >= end) {
                    break
                }
            }
        }
        return Math.max(end-start+1, 0)
    }
}
