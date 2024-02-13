class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val v = nums.toHashSet()
        var result = 0

        for(num in nums) {
            var left = num
            var right = num

            var count = 1
            v.remove(num)

            while(v.contains(--left)) {
                v.remove(left)
                count++
            }
            while(v.contains(++right)) {
                v.remove(right)
                count++
            }

            result = Math.max(result, count)
        }
        return result
    }
}
