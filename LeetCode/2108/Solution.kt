class Solution {
    fun firstPalindrome(words: Array<String>): String {
        var result = ""
        for(word in words) {
            if(isPalindrom(word)) {
                result = word
                break
            }
        }
        return result
    }

    fun isPalindrom(word: String): Boolean {
        val len = word.length

        for(i in 0 until len/2) {
            if(word[i] != word[len-i-1]) {
                return false
            }
        }

        return true
    }
}
