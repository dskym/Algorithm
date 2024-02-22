class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val inbound = IntArray(n) { 0 }
        val outbound = IntArray(n) { 0 }
        for(t in trust) {
            inbound[t[1]-1]++
            outbound[t[0]-1]++
        }
        var result = -1
        for(i in 0 until n) {
            if(inbound[i] == n-1 && outbound[i] == 0) {
                result = i+1
                break
            }
        }
        return result
    }
}
