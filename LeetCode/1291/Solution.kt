class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val result = mutableListOf<Int>()

        var minLength = 0
        var maxLength = 0

        var tempLow = low
        var tempHigh = high

        while(tempLow != 0) {
            tempLow /= 10
            minLength++
        }

        while(tempHigh != 0) {
            tempHigh /= 10
            maxLength++
        }

        for(i in minLength..maxLength) {
            for(j in 1..10-i) {
                var temp = j
                for(k in 1 until i) {
                    temp = 10*temp + j+k
                }
                if(temp >= low && temp <= high) {
                    result.add(temp)
                }
            }
        }

        return result
    }
}
