class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        var start = 0
        var end = people.size-1

        people.sort()

        var ret = 0
        while(start <= end) {
            ret++
            if(people[start] + people[end] <= limit) {
                start++
            }
            end--
        }
        return ret
    }
}
