class Solution {
    fun maxDepth(s: String): Int {
        val st = Stack<Char>()
        var result = 0
        for(c in s) {
            if(c == '(') {
                st.push(c)
            } else if(c == ')') {
                result = max(result, st.size)
                st.pop()
            }
        }
        return result
    }
}
