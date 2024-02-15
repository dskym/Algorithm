class Solution {
    fun largestPerimeter(nums: IntArray): Long {
        nums.sort()

        val prefix = LongArray(nums.size)
        prefix[0] = nums[0].toLong()
        for(i in 1 until prefix.size) {
            prefix[i] = nums[i].toLong() + prefix[i-1]
        }

        for(i in nums.size-1 downTo 1) {
            val base = nums[i]
            var sum = prefix[i-1]
            if(base < sum) {
                return (base+sum).toLong()
            }
        }
        return -1
    }
}
