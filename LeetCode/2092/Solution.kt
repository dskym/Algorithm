class Solution {
    fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
        val visited = BooleanArray(n) { false }
        
        val g = mutableMapOf<Int, MutableList<Node>>()
        for(m in meetings) {
            if(g.contains(m[0])) {
                g[m[0]]?.add(Node(m[2], m[1]))
            } else {
                val temp = mutableListOf<Node>()
                temp.add(Node(m[2], m[1]))
                g[m[0]] = temp
            }
            if(g.contains(m[1])) {
                g[m[1]]?.add(Node(m[2], m[0]))
            } else {
                val temp = mutableListOf<Node>()
                temp.add(Node(m[2], m[0]))
                g[m[1]] = temp
            }
        }

        val q = PriorityQueue<Node>(compareBy<Node> { it.time })
        q.add(Node(0, 0))
        q.add(Node(0, firstPerson))

        while(q.isNotEmpty()) {
            val t = q.poll()
            if(visited[t.person]) {
                continue
            }
            visited[t.person] = true
            if(g.contains(t.person)) {
                for(v in g[t.person]!!) {
                    if(t.time <= v.time) {
                        q.add(v)
                    }
                }
            }
        }

        val result = mutableListOf<Int>()
        for(i in 0 until n) {
            if(visited[i]) {
                result.add(i)
            }
        }
        return result
    }
}

data class Node(
    val time: Int,
    val person: Int,
)
