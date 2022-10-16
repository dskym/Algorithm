class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        var ret = IntArray(nums.size * 2)
        for(i in 0 until nums.size) {
            ret[i] = nums[i];
            ret[i+nums.size] = nums[i];
        }
        return ret;
    }
}
