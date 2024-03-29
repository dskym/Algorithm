class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val counter = mutableMapOf<Int, Int>()

        var result = 0L
        var left = 0
        var right = 0
        var maxValue = nums.max()

        while(right < nums.size) {
            val v = nums[right]
            counter[v] = counter.getOrDefault(v, 0)+1
            while(counter.getOrDefault(maxValue, 0) >= k) {
                val vv = nums[left]
                counter[vv] = counter.getOrDefault(vv, 0)-1
                result += nums.size-right
                left++
            }
            right++
        }
        return result
    }
}
