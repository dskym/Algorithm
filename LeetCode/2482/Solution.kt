class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size

        var oneRow = IntArray(n)
        var zeroRow = IntArray(n)
        var oneCol = IntArray(m)
        var zeroCol = IntArray(m)

        for(i in 0 until n) {
            var zero = 0
            var one = 0
            for(j in 0 until m) {
                if(grid[i][j] == 0)
                    zero++
                if(grid[i][j] == 1)
                    one++
            }
            zeroRow[i] = zero
            oneRow[i] = one
        }

        for(i in 0 until m) {
            var zero = 0
            var one = 0
            for(j in 0 until n) {
                if(grid[j][i] == 0)
                    zero++
                if(grid[j][i] == 1)
                    one++
            }
            zeroCol[i] = zero
            oneCol[i] = one
        }

        var diff = Array<IntArray>(n) {v -> IntArray(m)}
        for(i in 0 until n) {
            for(j in 0 until m) {
                diff[i][j] = oneRow[i] + oneCol[j] - zeroRow[i] - zeroCol[j]
            }
        }
        return diff
    }
}
