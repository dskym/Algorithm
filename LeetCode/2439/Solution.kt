class Solution {
    fun minimizeArrayValue(nums: IntArray): Int {
        var pre: Long = 0
        var ret = 0
        for(i in 0 until nums.size) {
            pre += nums[i]
            ret = Math.max(ret, Math.ceil(pre / (i+1).toDouble()).toInt())
        }
        return ret
    }
}
