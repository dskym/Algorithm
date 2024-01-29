class MyQueue() {
    val stack1 = LinkedList<Int>()
    val stack2 = LinkedList<Int>()

    fun push(x: Int) {
        stack1.add(x)
    }

    fun pop(): Int {
        if(stack2.isNotEmpty()) {
            return stack2.removeLast()
        }
        while(stack1.isNotEmpty()) {
            stack2.add(stack1.removeLast())
        }
        return stack2.removeLast()
    }

    fun peek(): Int {
        if(stack2.isNotEmpty()) {
            return stack2.last()
        }
        return stack1.first()
    }

    fun empty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */
