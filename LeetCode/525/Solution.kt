class Solution {
    fun findMaxLength(nums: IntArray): Int {
        val m = mutableMapOf<Int, Int>()
        var sum = 0
        var result = 0
        for(i in 0 until nums.size) {
            if(nums[i] == 0) {
                sum += -1
            } else {
                sum += 1
            }
            if(sum == 0) {
                result = i+1
            } else if(m.containsKey(sum)) {
                result = maxOf(result, i - m[sum]!!)
            } else {
                m[sum] = i
            }
        }
        return result
    }
}
