class Solution {
    fun bulbSwitch(n: Int): Int {
        val arr = MutableList<Int>(40001, {i -> i*i})
        var index = 1
        var ret = 0
        for(a in 1..n) {
            if(arr[index] == a) {
                ret++
                index++
            }
        }
        return ret
    }
}
