class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;
        while(curr != null) { 
            size++;
            curr = curr.next;
        }

        int remain = size % k;
        int nodeSize = size / k;

        curr = head;
        ListNode[] result = new ListNode[k];
        ListNode node = new ListNode();
        for(int i=0;i<k;++i) {
            for(int j=0;j<nodeSize;++j) {
                if(result[i] == null) {
                    result[i] = new ListNode(curr.val);
                    node = result[i];
                } else {
                    node.next = new ListNode(curr.val);
                    node = node.next;
                }
                curr = curr.next;
            }
            if(remain > 0) {
                if(result[i] == null) {
                    result[i] = new ListNode(curr.val);
                } else {
                    node.next = new ListNode(curr.val);
                }
                curr = curr.next;
                remain--;
            }
        }
        return result;
    }
}
