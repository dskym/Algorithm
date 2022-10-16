class Solution {
    fun buildArray(nums: IntArray): IntArray {
        var ret = IntArray(nums.size)
        for(i in 0 until nums.size) {
            ret[i] = nums[nums[i]]
        }
        return ret
    }
}
