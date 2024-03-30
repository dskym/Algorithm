class Solution {
    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        return solve(nums, k)-solve(nums, k-1)
    }

    fun solve(nums: IntArray, k: Int): Int {
        val counter = mutableMapOf<Int, Int>()
        var left = 0
        var right = 0
        var result = 0
        var count = 0
        while(right < nums.size) {
            val v = nums[right]
            if(counter.getOrDefault(v, 0) == 0) {
                count++
            }
            counter[v] = counter.getOrDefault(v, 0)+1
            while(count > k) {
                val vv = nums[left]
                counter[vv] = counter.getOrDefault(vv, 0)-1
                if(counter.getOrDefault(vv, 0) == 0) {
                    count--
                }
                left++
            }
            result += right-left+1
            right++
        }
        return result
    }
}
