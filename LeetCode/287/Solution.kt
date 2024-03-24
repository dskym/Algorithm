class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for(i in nums.indices) {
            val temp = abs(nums[i])
            if(nums[temp-1] > 0) {
                nums[temp-1] = -nums[temp-1]
            } else {
                return temp
            }
        }
        return 0
    }
}
