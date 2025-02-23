/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int index = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(0, preorder.length-1, preorder, postorder);
    }

    private TreeNode solve(int start, int end, int[] preorder, int[] postorder) {
        if(index >= preorder.length || start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);

        if(start == end) {
            return node;
        }

        int mid = start;
        while (postorder[mid] != preorder[index]) {
            mid++;
        }

        node.left = solve(start, mid, preorder, postorder);
        node.right = solve(mid+1, end-1, preorder, postorder);
        return node;
    }
}
