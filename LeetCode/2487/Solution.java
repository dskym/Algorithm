class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            while(stack.isEmpty() == false && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        ListNode newHead = null;
        while(stack.isEmpty() == false) {
            ListNode newNode = new ListNode(stack.peek().val);
            newNode.next = newHead;
            newHead = newNode;
            stack.pop();
        }
        return newHead;
    }
}
