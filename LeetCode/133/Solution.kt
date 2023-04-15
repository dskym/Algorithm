/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if(node == null)
            return null

        val visited = BooleanArray(101) {false}
        val nodes = arrayOfNulls<Node?>(101)

        val root = Node(node.`val`)
        nodes[node.`val`] = root

        val q: Queue<Pair<Node, Node>> = LinkedList<Pair<Node,Node>>()
        q.add(Pair(node, root))
        while(q.isNotEmpty()) {
            val t = q.poll();

            val f = t.first
            val s = t.second

            if(visited[f.`val`])
                continue

            visited[f.`val`] = true

            for(n in f.neighbors) {
                val newNode = nodes[n!!.`val`] ?: Node(n!!.`val`)
                nodes[n!!.`val`] = newNode
                s.neighbors.add(newNode)
                q.add(Pair(n, newNode))
            }
        }

        return root
    }
}
