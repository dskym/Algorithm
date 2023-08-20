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
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        if(head == null || head.next == null) {
            return head
        }

        var prev = head
        var curr = head.next

        while(curr != null) {
            val v = gcd(prev!!.`val`, curr!!.`val`)
            val newNode = ListNode(v)

            prev?.next = newNode
            newNode.next = curr

            prev = curr
            curr = curr.next
        }
        return head
    }

    fun gcd(a: Int, b: Int): Int {
        var temp = if (a > b) a else b
        for(i in 1..temp) {
            if(a % i == 0 && b % i == 0) {
                temp = i
            }
        }
        return temp
    }
}
