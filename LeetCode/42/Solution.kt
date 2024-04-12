class Solution {
    fun trap(height: IntArray): Int {
        val stack = Stack<Int>()

        var result = 0
        for(i in 0 until height.size) {
            val h = height[i]
            while(stack.isNotEmpty() && height[stack.peek()] < h) {
                val mid = stack.peek()
                stack.pop()
                if(stack.isEmpty()) {
                    break
                }
                val l = stack.peek()
                result += (min(h, height[l])-height[mid]) * (i-l-1)
            }
            stack.add(i)
        }
        return result
    }
}
