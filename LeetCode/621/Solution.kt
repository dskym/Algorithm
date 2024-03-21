class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counter = mutableMapOf<Char, Int>()
        val pos = mutableMapOf<Char, Int>()
        val pq = PriorityQueue<Pair<Char, Int>>{ a, b -> b.second-a.second }

        for(task in tasks) {
            counter[task] = counter.getOrDefault(task, 0) + 1
        }

        for((k, v) in counter) {
            pq.add(Pair(k, v))
        }

        var result = 0
        val tempQueue = LinkedList<Pair<Char, Int>>()
        while(pq.isNotEmpty() || tempQueue.isNotEmpty()) {
            while(tempQueue.isNotEmpty()) {
                pq.add(tempQueue.poll())
            }

            result++

            while(pq.isNotEmpty()) {
                val t = pq.poll()

                if(pos.containsKey(t.first) == false || result-pos[t.first]!! > n) {
                    pos[t.first] = result
                    if(t.second > 1) {
                        pq.add(Pair(t.first, t.second-1))
                    }
                    break
                } else {
                    tempQueue.add(Pair(t.first, t.second))
                }
            }
        }
        return result
    }
}
