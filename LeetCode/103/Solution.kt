/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
data class Node(
    var node: TreeNode,
    var count: Int
)
class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        var ret = mutableListOf<MutableList<Int>>()
        if(root == null) {
            return ret
        }

        var q: Queue<Node> = LinkedList()
        q.add(Node(root, 0))

        while(q.isNotEmpty()) {
            var t: Node = q.poll()

            if(ret.size == t.count) {
                ret.add(mutableListOf<Int>(t.node.`val`));
            } else {
                if(t.count % 2 == 1) {
                    ret[t.count].add(0, t.node.`val`)
                } else {
                    ret[t.count].add(t.node.`val`)
                }
            }

            if(t.node.left != null) {
                q.add(Node(t.node.left, t.count+1))
            }
            if(t.node.right != null) {
                q.add(Node(t.node.right, t.count+1))
            }
        }
        return ret
    }
}
