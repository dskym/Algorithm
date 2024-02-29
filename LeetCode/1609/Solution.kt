class Solution {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        if(root == null) {
            return true
        }

        var baseDepth = -1
        var baseNode = 0

        val q = LinkedList<Pair<TreeNode, Int>>()
        q.add(Pair(root, 0))
        while(q.isNotEmpty()) {
            val n = q.poll()
            val node = n.first
            val depth = n.second
            if(depth != baseDepth) {
                baseDepth = depth
                baseNode = node.`val`
            } else {
                if(depth % 2 == 0) {
                    if(node.`val` > baseNode) {
                        baseNode = node.`val`
                    } else {
                        return false
                    }
                } else {
                    if(node.`val` < baseNode) {
                        baseNode = node.`val`
                    } else {
                        return false
                    }
                }
            }
            if(depth % 2 == 0) {
                if(node.`val` % 2 != 1) {
                    return false
                }
            } else {
                if(node.`val` % 2 != 0) {
                    return false
                }
            }
            if(node.left != null) {
                q.add(Pair(node.left, depth+1))
            }
            if(node.right != null) {
                q.add(Pair(node.right, depth+1))
            }
        }
        return true
    }
}
