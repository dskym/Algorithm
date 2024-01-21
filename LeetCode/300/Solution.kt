class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        var size = nums.size
        var dp = IntArray(size)
        dp.fill(1)

        for(i in size-2 downTo 0) {
            for(j in i+1 until size) {
                if(nums[i] < nums[j]) {
                    dp[i] = max(dp[i], dp[j]+1)
                }
            }
        }

        var result = 0
        for(i in 0 until size) {
            if(result < dp[i]) {
                result = dp[i]
            }
        }
        return result
    }
}
