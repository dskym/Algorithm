class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var minIndex = -1
        var maxIndex = -1
        var baseIndex = 0

        var result = 0L
        for(i in 0 until nums.size) {
            if(minK > nums[i] || maxK < nums[i]) {
                baseIndex = i+1
                continue
            }
            if(maxK == nums[i]) {
                maxIndex=i
            }
            if(minK == nums[i]) {
                minIndex=i
            }
            result += max(min(maxIndex, minIndex)-baseIndex+1, 0)
        }
        return result
    }
}
