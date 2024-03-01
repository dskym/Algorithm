class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        var one = 0
        var zero = 0
        s.forEach {
            if(it == '1') {
                one++
            } else {
                zero++
            }
        }

        var result = ""
        for(i in 0 until one-1) {
            result += "1"
        }
        for(i in 0 until zero) {
            result += "0"
        }
        result += "1"
        return result
    }
}
