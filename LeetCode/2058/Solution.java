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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;

        int[] result = {-1, -1};
        List<Integer> temp = new ArrayList<>();
        int direction = prev.val < curr.val ? 1 : prev.val > curr.val ? -1 : 0;
        while(curr != null) {
            int newDirection = prev.val < curr.val ? 1 : prev.val > curr.val ? -1 : 0;
            if(direction == -newDirection && direction != 0) {
                temp.add(index-1);
            }
            index++;
            direction = newDirection;
            prev = curr;
            curr = curr.next;
        }
        if(temp.size() >= 2) {
            result[0] = temp.get(1)-temp.get(0);
            for(int i=2;i<temp.size();++i) {
                result[0] = Math.min(result[0], temp.get(i)-temp.get(i-1));
            }
            result[1] = temp.get(temp.size()-1)-temp.get(0);
        }
        return result;
    }
}
