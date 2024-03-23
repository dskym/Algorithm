/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        val s = Stack<ListNode>()
        var temp = head
        var count = 0
        while(temp != null) {
            s.push(temp)
            temp = temp.next
            count++
        }
        
        temp = head
        var l = 0
        while(temp != null) {
            if(l >= count/2) {
                temp.next = null
                break;
            }
            val t = temp.next
            val tt = s.peek()
            s.pop()
            temp.next = tt
            tt.next = t
            temp = t
            l++
        }
    }
}
