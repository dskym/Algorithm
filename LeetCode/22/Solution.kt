class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf(listOf(""))
        for(i in 0 until n) {
            val temp = mutableListOf<String>()
            for(j in 0 until i+1) {
                for(a in result[j]) {
                    for(b in result[i-j]) {
                        temp.add("($a)$b")
                    }
                }
            }
            result.add(temp)
        }
        return result.last()
    }
}
