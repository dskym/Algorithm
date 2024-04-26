class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root, targetSum, 0);
    }

    public boolean solve(TreeNode root, int targetSum, int curr) {
        if(root == null) {
            return false;
        }

        curr += root.val;

        if(root.left == null && root.right == null) {
            return targetSum == curr;
        }

        return solve(root.left, targetSum, curr) || solve(root.right, targetSum, curr);
    }
}
