class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val count = k % nums.size
        if(count != 0) {
            reverse(nums, 0, nums.size-1)
            reverse(nums, 0, count-1)
            reverse(nums, count, nums.size-1)
        }
    }

    fun reverse(nums: IntArray, start: Int, end: Int): Unit {
        for(i in 0 until (end - start+1)/2) {
            val temp = nums[start+i]
            nums[start+i] = nums[end-i]
            nums[end-i] = temp
        }
    }
}
