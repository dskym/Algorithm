class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val lambda = {
            a:Long, b:Long -> when {
                a>b -> 1
                a<b -> -1
                else -> 0
        }}
        val pq = PriorityQueue(Comparator<Pair<Long,Int>> {
            a,b -> when {
                a.first != b.first -> lambda(a.first,b.first)
                else -> lambda(a.second.toLong(), b.second.toLong())
        }})
        val room = PriorityQueue<Int>()
        
        val m = meetings.sortedWith(compareBy({it[0]},{it[1]}))

        for(i in 0 until n) {
            room.add(i)
        }

        val count = IntArray(n) {0}

        for(meeting in m) {
            while(pq.isNotEmpty()) {
                val t = pq.peek()
                if(meeting[0] >= t.first) {
                    val temp = pq.poll()
                    room.add(temp.second)
                } else {
                    break
                }
            }

            if(room.isEmpty()) {
                val time = pq.poll()
                if(time.first < meeting[0]) {
                    pq.add(Pair(meeting[1].toLong(), time.second))
                } else {
                    pq.add(Pair(((meeting[1]-meeting[0])+time.first).toLong(), time.second))
                }
                count[time.second]++
            } else {
                val r = room.poll()
                pq.add(Pair(meeting[1].toLong(), r))
                count[r]++
            }
        }

        var result = 0
        var index = 0
        for((i, c) in count.withIndex()) {
            if(c > result) {
                index = i
                result = c
            }
        }
        return index
    }
}
