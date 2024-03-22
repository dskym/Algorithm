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
    fun isPalindrome(head: ListNode?): Boolean {
        val s1 = Stack<Int>()
        val s2 = Stack<Int>()
        var count = 0

        var temp = head
        while(temp != null) {
            s1.push(temp.`val`)
            temp = temp.next
            count++
        }

        if(count % 2 == 1) {
            s1.pop()
        }

        for(i in 0 until count/2) {
            s2.push(s1.peek())
            s1.pop()
        }

        for(i in 0 until count/2) {
            if(s1.peek() != s2.peek()) {
                return false
            }
            s1.pop()
            s2.pop()
        }
        return true
    }
}
