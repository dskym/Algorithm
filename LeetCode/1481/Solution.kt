class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        var count = 0
        val m = mutableMapOf<Int, Int>()
        for(i in 0 until arr.size) {
            m[arr[i]] = m.getOrDefault(arr[i], 0)+1
        }
        val m2 = m.toList().sortedBy { it.second }
        var temp = k
        for((k, v) in m2) {
            if(temp > 0) {
                temp -= v
                if(temp < 0) {
                    count++
                }
            } else {
                count++
            }
        }
        return count
    }
}
