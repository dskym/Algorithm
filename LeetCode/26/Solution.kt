class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        var count = 0
        var index = 0
        for(num in nums) {
            if(set.contains(num)) {
                continue
            }
            nums[index++] = num
            set.add(num)
            count++
        }
        return count
    }
}
