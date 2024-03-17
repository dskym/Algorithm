class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var result = arrayOf<IntArray>()
        for(interval in intervals) {
            if(interval[0] <= newInterval[1] && newInterval[0] <= interval[1]) {
                newInterval[0] = minOf(newInterval[0], interval[0])
                newInterval[1] = maxOf(newInterval[1], interval[1])
            } else {
                result += interval
            }
        }
        result += newInterval
        result.sortBy {it[0] }
        return result
    }
}
