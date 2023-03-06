class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        var left = 0
        var right = arr.size-1

        while(left <= right) {
            var mid = (left + right) / 2
            
            var diff = arr[mid]-(mid+1)

            if (diff < k) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return left + k
    }
}
