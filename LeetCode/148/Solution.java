/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            n++;
        }

        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode left = sort(head);
        ListNode right = sort(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode newNode = new ListNode();
        ListNode t = newNode;
        while(left != null && right != null) {
            if(left.val < right.val) {
                t.next = left;
                left = left.next;
            } else {
                t.next = right;
                right = right.next;
            }
            t = t.next;
        }
        t.next = (left != null) ? left : right;
        return newNode.next;
    }
}
