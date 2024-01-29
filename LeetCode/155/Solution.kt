class MinStack() {
    val stack1 = LinkedList<Int>()
    val stack2 = LinkedList<Int>()

    fun push(`val`: Int) {
        stack1.add(`val`)
        if(stack2.isEmpty() || stack2.last() >= `val`) {
            stack2.add(`val`)
        }
    }

    fun pop() {
        if(stack1.last() == stack2.last()) {
            stack2.removeLast()
        }
        stack1.removeLast()
    }

    fun top(): Int {
        return stack1.last()
    }

    fun getMin(): Int {
        return stack2.last()
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

