class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val counter = IntArray(201) {0}
        val ret = mutableListOf<MutableList<Int>>()
        for(num in nums) {
            if(ret.size <= counter[num]) {
                ret.add(mutableListOf(num))
            } else {
                ret[counter[num]].add(num)
            }
            counter[num]++
        }        
        return ret
    }
}
