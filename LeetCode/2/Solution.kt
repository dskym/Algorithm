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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val result = ListNode(0)
        var carry = 0
        var current = result

        var ll1 = l1
        var ll2 = l2
        while(ll1 != null && ll2 != null) {
            val temp = ListNode((ll1.`val` + ll2.`val` + carry) % 10)
            carry = (ll1.`val` + ll2.`val` + carry) / 10
            current.next = temp
            current = temp
            ll1 = ll1.next
            ll2 = ll2.next
        }
        while(ll1 != null) {
            val temp = ListNode((ll1.`val` + carry) % 10)
            carry = (ll1.`val` + carry) / 10
            current.next = temp
            current = temp
            ll1 = ll1.next
        }
        while(ll2 != null) {
            val temp = ListNode((ll2.`val` + carry) % 10)
            carry = (ll2.`val` + carry) / 10
            current.next = temp
            current = temp
            ll2 = ll2.next
        }
        if(carry > 0) {
            val temp = ListNode(carry)
            current.next = temp
        }
        return result.next
    }
}
