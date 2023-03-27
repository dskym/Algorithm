class Solution {
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        if(edges.size == 0)
            return (n * (n-1).toLong()) / 2

        var graph = Array(n, {i -> arrayListOf<Int>()})
        for(i in 0 until edges.size) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        var arr = arrayListOf<Int>();
        var visited = BooleanArray(n) { false };
        for(i in 0 until n) {
            if(visited[i])
                continue

            var count = 1;
            var q: Queue<Int> = LinkedList<Int>()
            q.add(i)
            visited[i] = true;

            while(q.size != 0) {
                var t = q.poll()

                for(j in 0 until graph[t].size) {
                    if(visited[graph[t][j]] == false) {
                        q.add(graph[t][j])
                        visited[graph[t][j]] = true
                        count++
                    }
                }
                println(t)
            }

            arr.add(count)
        }

        var result = 0L
        for(i in 0 until arr.size) {
            for(j in i+1 until arr.size) {
                result += arr[i] * arr[j].toLong()
            }
        }
        return result
    }
}
