class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size

        potions.sort()

        val ret = IntArray(n)
        for((i, v) in spells.withIndex()) {
            var left = 0
            var right = m-1
            while(left <= right) {
                var mid: Int = (left + right) / 2
                if(potions[mid] * v.toLong() >= success) {
                    right = mid-1
                } else {
                    left = mid + 1
                }
            }
            ret[i] = m - left
        }
        return ret
    }
}
