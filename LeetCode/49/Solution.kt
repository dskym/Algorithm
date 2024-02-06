class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val m = mutableMapOf<String, MutableList<String>>()
        for(str in strs) {
            val temp = str.toCharArray().sorted().joinToString("")
            val l = m.getOrDefault(temp, mutableListOf<String>())
            l.add(str)
            m[temp] = l
        }
        return m.values.toList()
    }
}
