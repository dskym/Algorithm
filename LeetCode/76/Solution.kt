class Solution {
    fun minWindow(s: String, t: String): String {
        val counter = IntArray(127)
        for(c in t) {
            counter[c.toInt()]++
        }

        var start = 0
        var end = 0

        var result = ""
        while(end < s.length) {
            counter[s[end++].toInt()]--
            var flag = true
            for(temp in counter) {
                if(temp > 0) {
                    flag = false
                }
            }
            if(flag) {
                while(start < end) {
                    if(result == "") {
                        result = s.substring(start, end)
                    } else if(result != "" && result.length > end-start) {
                        result = s.substring(start, end)
                    }
                    counter[s[start++].toInt()]++
                    var flag2 = false
                    for(temp in counter) {
                        if(temp > 0) {
                            flag2 = true
                        }
                    }
                    if(flag2) {
                        break
                    }
                }
            }
        }
        return result
    }
}
