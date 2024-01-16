class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val score = mutableMapOf<Int, Int>()

        for(match in matches) {
            if(match[0] !in score) {
                score[match[0]] = 0
            }
            
            score.put(match[1], score.getOrDefault(match[1], 0) + 1)
        }

        val ans1 = score.filterValues { it == 0 }.keys.toList().sorted()
        val ans2 = score.filterValues { it == 1 }.keys.toList().sorted()

        return listOf(ans1, ans2)
    }
}
