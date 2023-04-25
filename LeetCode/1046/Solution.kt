class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        stones.forEach {
            pq.offer(it)
        }
        while(pq.size >= 2) {
            val a = pq.poll()
            val b = pq.poll()

            if(a > b) {
                pq.offer(a-b)
            }
        }

        return pq.poll() ?: 0
    }
}
