class Solution {
    fun removeStars(s: String): String {
        val arr = CharArray(100000)
        var pos = 0

        s.forEach {
            if(it != '*') {
                arr[pos++] = it
            } else {
                pos--
            }
        }

        var ret = ""
        for(i in 0 until pos) {
            ret += arr[i]
        }
        return ret
    }
}
