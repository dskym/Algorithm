class Solution {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        var score = 0
        tokens.sort()
        var start = 0
        var end = tokens.size-1
        var p = power
        var result = 0
        while(start <= end) {
            if(p >= tokens[start]) {
                p -= tokens[start]
                score++
            } else {
                if(score > 0) {
                    p += tokens[end--]
                    score--
                    continue
                }
            }
            start++
            result = Math.max(result, score)
        }
        return result
    }
}
