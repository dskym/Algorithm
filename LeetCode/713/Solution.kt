class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        if(k <= 1) {
            return 0
        }

        var result = 0
        var j = nums.size-1
        var temp = 1

        for(i in nums.size-1 downTo 0) {
            temp *= nums[i]

            while(temp >= k) {
                temp /= nums[j--]
            }         

            result += j-i+1
        }
        return result
    }
}

