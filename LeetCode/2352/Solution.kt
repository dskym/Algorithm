class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val m = mutableMapOf<Int, MutableList<Int>>()
        for(i in 0 until grid.size) {
            val l = m.getOrDefault(grid[i][0], mutableListOf<Int>())
            l.add(i)
            m[grid[i][0]] = l
        }

        var result = 0
        for(i in 0 until grid[0].size) {
            for(row in m.getOrDefault(grid[0][i], listOf())) {
                var flag = true
                for(j in 0 until grid.size) {
                    if(grid[row][j] != grid[j][i]) {
                        flag = false
                        break
                    }
                }
                if(flag) {
                    result++
                }
            }
        }
        return result
    }
}
