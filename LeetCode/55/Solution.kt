class Solution {
    fun canJump(nums: IntArray): Boolean {
        val size = nums.size
        val visited = BooleanArray(size)
        visited.fill(false)

        val queue = LinkedList<Int>()
        queue.add(0)
        visited[0] = true

        while(queue.isNotEmpty()) {
            val t = queue.poll()

            if(t == size-1) {
                return true
            } else if(t >= size) {
                continue
            }

            for(i in nums[t] downTo 1) {
                if(t+i < size && visited[t+i] == false) {
                    queue.push(t+i)
                    visited[t+i] = true
                }
            }
        }

        return false
    }
}
