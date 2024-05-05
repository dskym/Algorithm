class Solution {
    public void flatten(TreeNode root) {
        solve(root);
    }

    TreeNode solve(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);

        if(left != null) {
            TreeNode temp = left;
            while(temp.right != null) {
                temp = temp.right;
            }
            temp.right = right;
            root.right = left;
            root.left = null;
        } else {
            root.right = right;
        }

        return root;
    }
}
