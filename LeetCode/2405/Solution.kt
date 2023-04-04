class Solution {
    fun partitionString(s: String): Int {
        var m = mutableMapOf<Char, Boolean>()
        var count = 0
        for(c in s) {
            if(m.contains(c)) {
                count++
                m.clear()
            }
            m.put(c, true)
        }
        if(m.isNotEmpty()) {
            count++
        }
        return count
    }
}
