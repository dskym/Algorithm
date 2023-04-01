class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        var g = charArrayOf('M', 'P', 'G')
        var cost = 0
        for((i, v) in g.withIndex()) {
            var lastVisited = 0
            for((j, ga) in garbage.withIndex()) {
                for(c in ga) {
                    if(c == v) {
                        for(k in lastVisited until j) {
                            cost += travel[k]
                        }
                        lastVisited = j
                        cost += 1
                    }
                }
            }
        }

        return cost
    }
}
