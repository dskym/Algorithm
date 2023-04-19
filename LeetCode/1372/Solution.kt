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
    fun longestZigZag(root: TreeNode?): Int {
        return Math.max(solve(root, Direction.LEFT, 0), solve(root, Direction.RIGHT, 0))
    }

    fun solve(root: TreeNode?, direction: Direction, count: Int): Int {
        if(root == null)
            return 0

        if((direction == Direction.RIGHT && root.right == null)
            || (direction == Direction.LEFT && root.left == null)) {
                return count
            }
        
        var ret = 0
        if(direction == Direction.RIGHT) {
            ret = Math.max(solve(root.right, Direction.LEFT, count+1), solve(root.right, Direction.RIGHT, 0))
        } else if(direction == Direction.LEFT) {
            ret = Math.max(solve(root.left, Direction.RIGHT, count+1), solve(root.left, Direction.LEFT, 0))
        }
        return ret
    }

    enum class Direction{
        LEFT, RIGHT
    }
}
