class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums[0]
        } else if(nums.size == 2) {
            return max(nums[0], nums[1])
        }

        val dp1 = IntArray(nums.size+1){0}
        val dp2 = IntArray(nums.size+1){0}

        dp1[nums.size-2] = nums[nums.size-2]
        for(i in nums.size-3 downTo 0) {
            dp1[i] = max(nums[i]+dp1[i+2], dp1[i+1])
        }

        dp2[nums.size-1] = nums[nums.size-1]
        for(i in nums.size-2 downTo 1) {
            dp2[i] = max(nums[i]+dp2[i+2], dp2[i+1])
        }
        return max(dp1[0], dp2[1])
    }
}

