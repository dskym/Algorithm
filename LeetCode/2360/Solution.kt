class Solution {
    fun longestCycle(edges: IntArray): Int {
        var ret = -1
        val visited = BooleanArray(edges.size) { false }

        for(i in 0 until edges.size) {
            if(visited[i])
                continue

            val queue = LinkedList<Int>()
            val map = HashMap<Int, Int>()
            var len = 0
            queue.add(i)

            while(queue.isNotEmpty()) {
                val t = queue.poll()

                if(t == -1) {
                    break
                }

                if(visited[t] && map.containsKey(t)) {
                    val result = len - map.get(t)!!
                    ret = if (result > ret) result else ret
                    break
                }

                if(visited[t]) {
                    break
                }

                map.put(t, len++);
                visited[t] = true;
                queue.add(edges[t])
            }
        }
        return ret
    }
}
