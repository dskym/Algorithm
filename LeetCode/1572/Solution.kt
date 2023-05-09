class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        var ret = 0
        if(n % 2 == 1) {
            for(i in 0 until n) {
                ret += mat[i][i]
                ret += mat[i][n-i-1]
            }
            ret -= mat[n/2][n/2]
        } else {
            for(i in 0 until n) {
                ret += mat[i][i]
                ret += mat[i][n-i-1]
            }
        }
        return ret
    }
}
