class Solution {
    fun rob(nums: IntArray): Int {
        if(nums.size == 1) {
            return nums[0]
        } else if(nums.size == 2) {
            return max(nums[1], nums[0])
        }

        val dp = IntArray(nums.size) {0}
        dp[nums.size-1] = nums[nums.size-1]
        dp[nums.size-2] = max(nums[nums.size-2], nums[nums.size-1])

        for(i in nums.size-3 downTo 0) {
            dp[i] = max(dp[i+1], nums[i]+dp[i+2])
        }

        return dp[0]
    }
}

