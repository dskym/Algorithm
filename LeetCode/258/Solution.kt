class Solution {
    fun addDigits(num: Int): Int {
        var ret = num
        while(ret / 10 != 0) {
            var temp = ret
            var l = 0
            while(temp != 0) {
                l += temp % 10
                temp /= 10
            }
            ret = l
        }
        return ret
    }
}
