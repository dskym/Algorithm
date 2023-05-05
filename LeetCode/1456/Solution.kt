class Solution {
    fun maxVowels(s: String, k: Int): Int {
        var ret = 0
        var count = 0
        for(i in 0 until k) {
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                count++
            }
        }
        ret = count

        for(i in 0 until s.length-k) {
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                count--
            }
            if(s[i+k] == 'a' || s[i+k] == 'e' || s[i+k] == 'i' || s[i+k] == 'o' || s[i+k] == 'u') {
                count++
        }
            ret = Math.max(ret, count)
        }
        return ret
    }
}
