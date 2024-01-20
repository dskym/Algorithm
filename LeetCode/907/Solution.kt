class Solution {
    fun sumSubarrayMins(arr: IntArray): Int {
        var result = 0
        val size = arr.size

        val left = LongArray(size)
        val right = LongArray(size)

        left.fill(1)
        right.fill(1)

        val leftStack = Stack<Int>()
        leftStack.push(size-1)
        for(i in size-2 downTo 0) {
            while(leftStack.isNotEmpty() && arr[leftStack.peek()] >= arr[i]) {
                left[i] += left[leftStack.peek()]
                leftStack.pop()
            }
            leftStack.push(i)
        }

        val rightStack = Stack<Int>()
        rightStack.push(0)
        for(i in 1 until size) {
            while(rightStack.isNotEmpty() && arr[rightStack.peek()] > arr[i]) {
                right[i] += right[rightStack.peek()]
                rightStack.pop()
            }
            rightStack.push(i)
        }

        for(i in 0 until size) {
            val temp = (left[i] * right[i]) % 1000000007
            val temp2 = (temp * arr[i]) % 1000000007
            result = (result + temp2.toInt()) % 1000000007
        }

        return result
    }
}


