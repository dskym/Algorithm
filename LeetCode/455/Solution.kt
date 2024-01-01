class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        val greed = g.sorted().reversed()
        val cookie = s.sorted().reversed()

        var result = 0
        var index = 0
        for(i in 0 until g.size){
            if(index < s.size && cookie[index] >= greed[i]) {
                result++
                index++
            }
        }
        return result
    }
}
