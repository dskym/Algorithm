class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        if(k == 0) {
            return head;
        }

        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp = temp.next;
        }

        int rotate = k % len;
        if(rotate == 0) {
            return head;
        }

        ListNode first = null;
        ListNode second = head;

        for(int i=0;i<len-rotate;++i) {
            first = second;
            second = second.next;
        }
        first.next = null;

        ListNode tail = second;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;

        return second;
    }
}
