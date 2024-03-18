class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        var result = 1
        points.sortBy { it[0] }
        for(i in 1 until points.size) {
            if(points[i][0] > points[i-1][1]) {
                result++
            } else {
                points[i][0] = minOf(points[i][0], points[i-1][0])
                points[i][1] = minOf(points[i][1], points[i-1][1])
            }
        }
        return result
    }
}
