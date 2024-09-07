class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return solve(head, head, root);
    }

    public boolean solve(ListNode head, ListNode originalHead, TreeNode root) {
        if(head == null) {
            return true;
        }

        if(root == null) {
            return false;
        }

        if(head.val == root.val) {
            head = head.next;
        } else if(originalHead.val == root.val) {
            originalHead = originalHead.next;
        } else {
            head = originalHead;
        }

        boolean left = solve(head, originalHead, root.left);
        boolean right = solve(head, originalHead, root.right);

        return left || right;
    }
}
