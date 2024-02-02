class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        var index = 0
        for(i in 0 until nums.size) {
            if(nums[i] == `val`) {
                continue
            }
            nums[index++] = nums[i]
            count++
        }
        return count
    }
}
