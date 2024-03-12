class Solution {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val result = ListNode(0)
        result.next = head

        var start: ListNode? = result
        while(start != null) {
            var temp = 0
            var end = start.next

            while(end != null) {
                temp += end.`val`
                if(temp == 0) {
                    start.next = end.next
                }
                end = end.next
            }

            start = start.next
        }

        return result.next
    }
}
