class Solution {
    fun divideArray(nums: IntArray, k: Int): Array<IntArray> {
        nums.sort()
        for(i in 0 until nums.size / 3) {
            if((nums[3*i+2] - nums[3*i]) > k) {
                return arrayOf()
            }
        }
        val result = Array<IntArray>(nums.size / 3) { IntArray(3) }
        for(i in 0 until nums.size / 3) {
            val temp = IntArray(3)
            for(j in 0 until 3) {
                temp[j] = nums[i*3+j]
            }
            result[i] = temp
        }
        return result
    }
}
