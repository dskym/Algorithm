class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val m = mutableMapOf<Int, Int>()
        var left = 0
        var right = 0

        var result = 0

        while(left <= right && right < nums.size) {
            //update
            m[nums[right]] = m.getOrDefault(nums[right], 0)+1

            //check
            while(m[nums[right]]!! > k && left <= right) {
                if(m[nums[left]]!! == 0) {
                    break
                }
                m[nums[left]] = m[nums[left]]!!-1
                left++
            }

            result = maxOf(result, right-left+1)

            right++
        }

        return result
    }
}
