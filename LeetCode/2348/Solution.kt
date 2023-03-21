class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var ret: Long = 0

        var count = 0
        for(num in nums) {
            if(num == 0) {
                count++
            } else {
                ret += (count / 2.0 * (count+1)).toLong()
                count=0
            }
        }
        ret += (count / 2.0 * (count+1)).toLong()

        return ret
    }
}

