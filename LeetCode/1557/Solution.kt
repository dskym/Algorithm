class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val visited = BooleanArray(n) { true }
        val ret = arrayListOf<Int>()

        for((s, v) in edges) {
            visited[v] = false
        }

        for((i, v) in visited.withIndex()) {
            if(v) {
                ret.add(i)
            }
        }
        return ret
    }
}
