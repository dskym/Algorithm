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
class Solution {
    val minWidth = LongArray(3001) {Long.MAX_VALUE}
    val maxWidth = LongArray(3001) {Long.MIN_VALUE}

    fun widthOfBinaryTree(root: TreeNode?): Int {
        solve(root, 0, 0)
        var ret: Long = 0
        for(i in 0 until 3001) {
            if(maxWidth[i] != Long.MIN_VALUE && minWidth[i] != Long.MAX_VALUE) {
                ret = Math.max(ret, maxWidth[i] - minWidth[i])
            }
        }
        return (ret+1).toInt()
    }

    fun solve(root: TreeNode?, width: Long, depth: Int) {
        if(root == null)
            return

        solve(root.left, 2*width, depth+1)
        solve(root.right, 2*width+1, depth+1)

        minWidth[depth] = Math.min(minWidth[depth], width)
        maxWidth[depth] = Math.max(maxWidth[depth], width)
    }
}
