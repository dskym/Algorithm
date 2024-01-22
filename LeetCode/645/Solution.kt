class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val a = nums.sorted()
        val result = IntArray(2)
        for(i in 0 until a.size) {
            if(i+1 != a[i]) {
                result[0] = a[i]
                result[1] = i+1
                break
            }
        }
        return result
    }
}
