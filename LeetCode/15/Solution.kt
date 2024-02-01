class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableSetOf<List<Int>>()
        for(i in nums.size-1 downTo 1) {
            var start = 0
            var end = i - 1
            while(start < end) {
                if((nums[start] + nums[end]) == -1 * nums[i]) {
                    result.add(listOf(nums[start], nums[end], nums[i]))
                    start++
                    end--
                } else if((nums[start] + nums[end]) > -1 * nums[i]) {
                    end--
                } else if((nums[start] + nums[end]) < -1 * nums[i]) {
                    start++
                }
            }
        }
        return result.toList()
    }
}

