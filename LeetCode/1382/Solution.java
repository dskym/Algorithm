class Solution {
    List<Integer> list = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        intraversal(root);
        return buildBST(list, 0, list.size()-1);
    }

    public void intraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        
        intraversal(node.left);
        list.add(node.val);
        intraversal(node.right);
    }

    public TreeNode buildBST(List<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBST(list, start, mid-1);
        root.right = buildBST(list, mid+1, end);
        return root;
    }
}
