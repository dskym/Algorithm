class Solution {
    fun removeKdigits(num: String, k: Int): String {
        val stack = Stack<Char>()
        var count = k

        stack.add(num[0])

        for(i in 1 until num.length) {
            while(stack.isNotEmpty() && stack.peek() > num[i] && count > 0) {
                stack.pop()
                count--
            }
            stack.add(num[i])
        }

        while(count > 0) {
            stack.pop()
            count--
        }

        var result = ""
        while(stack.isNotEmpty()) {
            result = stack.peek() + result
            stack.pop()
        }

        var index = 0
        var flag = true
        for(i in 0 until result.length) {
            if(result[i] != '0') {
                index = i
                flag = false
                break
            }
        }
        
        if(result == "" || flag) {
            return "0"
        } else {
            return result.substring(index)
        }
    }
}
