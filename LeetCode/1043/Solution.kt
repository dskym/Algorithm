class Solution {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val size = arr.size
        val dp = IntArray(size+k)

        for(i in size-1 downTo 0) {
            for(j in 1..k) {
                if(i+j > size)
                    continue
                var t = 0
                var m = 0
                for(k in 0 until j) {
                    if(i+k < size && m < arr[i+k]) {
                        m = arr[i+k]
                    }
                }
                dp[i] = Math.max(dp[i], m*j+dp[i+j])
            }
        }
        return dp[0]
    }
}
