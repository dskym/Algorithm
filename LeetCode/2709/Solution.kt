class Solution {
    fun canTraverseAllPairs(nums: IntArray): Boolean {
        val primeToIndex = mutableMapOf<Int, MutableList<Int>>()
        for (i in 0 until nums.size) {
            var number = nums[i]
            var factor = 2
            while (factor * factor <= number) {
                if (number % factor == 0) {
                    primeToIndex.getOrPut(factor) { mutableListOf() }.add(i)
                    while (number % factor == 0) {
                        number /= factor
                    }
                }
                factor++
            }
            if (number > 1) {
                primeToIndex.getOrPut(number) { mutableListOf() }.add(i)
            }
        }

        val parents = IntArray(nums.size) { it }
        for ((_, indices) in primeToIndex) {
            for (i in 1 until indices.size) {
                union(parents, indices[i], indices[0])
            }
        }

        val temp = find(parents, 0)
        for(num in 1 until nums.size) {
            if(temp != find(parents, num)) {
                return false
            }
        }
        return true
    }
}

fun find(parents: IntArray, node: Int): Int {
    if(parents[node] == node) {
        return node
    } else {
        parents[node] = find(parents, parents[node]!!)
    }
    return parents[node]!!
}

fun union(parents: IntArray, node1: Int, node2: Int): Unit {
    val root1 = find(parents, node1)
    val root2 = find(parents, node2)

    if(root1 != root2) {
        parents[root1] = root2
    }
}
