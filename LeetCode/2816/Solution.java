class Solution {
    public ListNode doubleIt(ListNode head) {
        int ret = solve(head);
        if(ret == 1) {
            return new ListNode(1, head);
        } else {
            return head;
        }
    }

    public int solve(ListNode node) {
        if(node == null) {
            return 0;
        }
        int carry = solve(node.next);
        int temp = node.val*2+carry;
        node.val = temp % 10;
        return temp/10;
    }
}
