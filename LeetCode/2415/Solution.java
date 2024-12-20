class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1);
        return root;
    }

    private void solve(TreeNode left, TreeNode right, int depth) {
        if(left == null || right == null) {
            return;
        }

        if(depth % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        solve(left.left, right.right, depth+1);
        solve(left.right, right.left, depth+1);
     }
}
