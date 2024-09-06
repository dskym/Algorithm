class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for(int num : nums) {
            s.add(num);
        }

        ListNode start = new ListNode();
        ListNode temp = head;
        ListNode temp2 = start;
        while(temp != null) {
            if(s.contains(temp.val) == false) {
                ListNode newNode = new ListNode(temp.val);
                temp2.next = newNode;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        return start.next;
    }
}
