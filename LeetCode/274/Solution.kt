class Solution {
    fun hIndex(citations: IntArray): Int {
        citations.sort()
        var l = 0
        var r = 1000
        var mid = 0
        var result = 0

        while(l <= r) {
            mid = (l+r)/2

            var count = 0
            for(citation in citations) {
                if(citation >= mid) {
                    count++
                }
            }
            
            if(count >= mid) {
                l = mid + 1
                result = Math.max(result, mid)
            } else {
                r = mid - 1
            }
        }

        return result
    }
}
