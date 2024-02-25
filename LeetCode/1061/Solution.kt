class Solution {
    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        val parents = mutableMapOf<Char, Char>()
        for(c in 'a'..'z') {
            parents[c] = c
        }

        for(i in 0 until s1.length) {
            union(parents, s1[i], s2[i])
        }

        var result = ""
        for(c in baseStr) {
            result += find(parents, c)
        }
        return result
    }

    fun find(parents: MutableMap<Char, Char>, node: Char): Char {
        if(parents[node] == node) {
            return parents[node]!!
        } else {
            parents[node] = find(parents, parents[node]!!)
        }
        return parents[node]!!
    }

    fun union(parents: MutableMap<Char, Char>, node1: Char, node2: Char) {
        val p1 = find(parents, node1)
        val p2 = find(parents, node2)

        if(p1 < p2) {
            parents[p2] = p1
        } else if(p1 > p2) {
            parents[p1] = p2
        }
    }
}
