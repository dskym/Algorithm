class Solution {
    fun pivotInteger(n: Int): Int {
        val preSum = mutableListOf<Int>()
        preSum.add(0)

        var temp = 0
        for(i in 1..1000) {
            temp += i
            preSum.add(temp)
        }

        for(i in 1..n) {
            val left = preSum[i]
            val right = preSum[n] - preSum[i-1]

            if(left == right) {
                return i
            }
        }

        return -1
    }
}
