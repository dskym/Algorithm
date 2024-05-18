class Solution {
    public int getMinimumDifference(TreeNode root) {
        return solve(root);
    }
    public int getLeftMax(TreeNode root) {
        TreeNode node = root.left;
        int result = -1;
        while(node != null) {
            result = node.val;
            node = node.right;
        }
        return result;
    }
    public int getRightMin(TreeNode root) {
        TreeNode node = root.right;
        int result = -1;
        while(node != null) {
            result = node.val;
            node = node.left;
        }
        return result;
    }
    public int solve(TreeNode root) {
        if(root == null) {
            return 100000;
        }

        int result = 100000;

        int left = solve(root.left);
        int right = solve(root.right);

        int leftMax = getLeftMax(root);
        int rightMin = getRightMin(root);

        if(leftMax != -1) {
            result = Math.min(result, Math.abs(root.val-leftMax));            
        }

        if(rightMin != -1) {
            result = Math.min(result, Math.abs(root.val-rightMin));            
        }

        result = Math.min(result, left);
        result = Math.min(result, right);

        return result;
    }
}
