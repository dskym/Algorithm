class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandy: Int = candies.max() ?: 0
        val ret = arrayListOf<Boolean>()
        candies.forEach {
            if(maxCandy - it <= extraCandies) {
                ret.add(true)
            } else {
                ret.add(false)
            }
        }
        return ret
    }
}
