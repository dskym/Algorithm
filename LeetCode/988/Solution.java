class Solution {
    String result = "";

    public String smallestFromLeaf(TreeNode root) {
        solve(root, "");
        return result;
    }

    public void solve(TreeNode root, String path) {
        if(root == null) {
            return;
        }

        char c = (char)(root.val + 'a');
        String newPath = c+path;

        if(root.left == null && root.right == null) {
            System.out.println(newPath);
            System.out.println(result);
            if(result.length() == 0 || newPath.compareTo(result)<0) {
                result = newPath;
            }
        }

        solve(root.left, newPath);
        solve(root.right, newPath);
    }
}
