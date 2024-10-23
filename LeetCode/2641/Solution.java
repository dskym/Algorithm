class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode replaceValueInTree(TreeNode root) {
        prepare(root, 1);

        TreeNode newRoot = new TreeNode(0);
        solve(root, newRoot, 1);
        return newRoot;   
    }

    private void prepare(TreeNode root, int depth) {
        if(root == null) {
            return;
        }

        Integer sum = map.getOrDefault(depth, 0);
        map.put(depth, sum+root.val);
        prepare(root.left, depth+1);
        prepare(root.right, depth+1);
    }

    private void solve(TreeNode root, TreeNode newRoot, int depth) {
        if(root.left == null && root.right == null) {
            return;
        }

        int base = 0;
        if(root.left != null) {
            base += root.left.val;
        }
        if(root.right != null) {
            base += root.right.val;
        }

        if(root.left != null) {
            TreeNode newNode = new TreeNode(map.get(depth+1)-base);
            newRoot.left = newNode;
            solve(root.left, newRoot.left, depth+1);
        }

        if(root.right != null) {
            TreeNode newNode = new TreeNode(map.get(depth+1)-base);
            newRoot.right = newNode;
            solve(root.right, newRoot.right, depth+1);
        }
    }
}
