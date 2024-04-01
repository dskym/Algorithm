class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = matrix.size * matrix[0].size-1

        while(left <= right) {
            val mid = (left+right)/2
            val r = mid / matrix[0].size
            val c = mid % matrix[0].size

            if(matrix[r][c] < target) {
                left = mid+1
            } else if(matrix[r][c] > target) {
                right = mid-1
            } else {
                return true
            }
        }
        return false
    }
}
