class Solution {
    var result = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        solve(root)
        return result
    }

    fun solve(root: TreeNode?): Int {
        if(root == null) {
            return 0
        }

        val left = solve(root.left)
        val right = solve(root.right)

        result = Math.max(result, left+right)
        return Math.max(left, right)+1
    }
}
