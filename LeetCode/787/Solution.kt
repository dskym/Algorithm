class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val graph = Array<IntArray>(101) { IntArray(101) { 0 } }
        val dp = IntArray(101) { Int.MAX_VALUE }
        for(flight in flights) {
            graph[flight[0]][flight[1]] = flight[2]
        }
        
        val queue = LinkedList<Model>()
        queue.add(Model(0, src))
        dp[src] = 0

        for(i in 0..k) {
            var s = queue.size
            while(s-- > 0) {
                val model = queue.poll()
                for(i in 0 until n) {
                    if(graph[model.node][i] != 0 && model.cost + graph[model.node][i] < dp[i]) {
                        dp[i] = model.cost + graph[model.node][i]
                        queue.add(Model(dp[i], i))
                    }
                }
            }
        }
        return if(dp[dst] == Int.MAX_VALUE) -1 else dp[dst]
    }
}

data class Model(
    val cost: Int,
    val node: Int,
)
