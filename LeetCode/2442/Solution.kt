class Solution {
    fun countDistinctIntegers(nums: IntArray): Int {
        val ret = mutableSetOf<Int>()
        for(num in nums) {
            ret.add(num)
            ret.add(num.toString().reversed().toInt())
        }
        return ret.size
    }
}
