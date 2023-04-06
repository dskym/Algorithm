class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(0, 1),
            intArrayOf(0, -1)
        )

        var ret = 0

        val n = grid.size
        val m = grid[0].size

        var visited = Array(n){BooleanArray(m){false}}
        for(i in 0 until n) {
            for(j in 0 until m) {
                if(visited[i][j] || grid[i][j] == 1)
                    continue

                var queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
                queue.add(Pair(i, j))
                visited[i][j] = true

                var flag = true

                while(queue.isNotEmpty()) {
                    var t = queue.poll()

                    val x = t.first
                    val y = t.second

                    if(x == 0 || x == n-1 || y == 0 || y == m-1) {
                        flag = false
                    }

                    for((dx, dy) in directions) {
                        val xx = x + dx
                        val yy = y + dy

                        if(xx >= 0 && xx < n && yy >= 0 && yy < m && visited[xx][yy] == false && grid[xx][yy] == 0) {
                            queue.add(Pair(xx, yy))
                            visited[xx][yy] = true
                        }
                    }
                }

                if(flag) {
                    ret++
                }
            }
        }

        return ret
    }
}
