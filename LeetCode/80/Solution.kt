class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        val size = nums.size
        var base = -100000
        var count = 0
        var index = 0

        for(i in 0 until size) {
            if(base == nums[i]) {
                if(count >= 2) {
                    continue
                }
                count++
            } else {
                base = nums[i]
                count = 1
            }
            nums[index++] = nums[i]
        }

        return index
    }
}
