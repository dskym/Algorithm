class Solution {
    fun minRemoveToMakeValid(s: String): String {
        val stack1 = Stack<Char>()
        var result1 = ""
        for(c in s) {
            if(c == '(') {
                stack1.push(c)
                result1 += c
            } else if(c == ')') {
                if(stack1.isNotEmpty() && stack1.peek() == '(') {
                    stack1.pop()
                    result1 += c
                }
            } else {
                result1 += c
            }
        }

        val stack2 = Stack<Char>()
        var result2 = ""
        for(i in result1.length-1 downTo 0) {
            val c = result1[i]
            if(c == ')') {
                stack2.push(c)
                result2 = c + result2
            } else if(c == '(') {
                if(stack2.isNotEmpty() && stack2.peek() == ')') {
                    stack2.pop()
                result2 = c + result2
                }
            } else {
                result2 = c + result2
            }
        }
        return result2
    }
}
