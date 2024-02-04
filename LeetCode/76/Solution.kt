class Solution {
    fun minWindow(s: String, t: String): String {
        val counter = IntArray(127)
        for(c in t) {
            counter[c.toInt()]++
        }

        var start = 0
        var end = 0
        var count = t.length

        var result = ""
        while(end < s.length) {
            if(counter[s[end++].toInt()]-- > 0) {
                count--
            }
            while(count == 0) {
                if(result == "" || result.length > end-start) {
                    result = s.substring(start, end)
                }
                if(++counter[s[start++].toInt()] > 0) {
                    count++
                }
            }
        }
        return result
    }
}
