class SmallestInfiniteSet() {
    val visited = BooleanArray(1001) { false }
    var cur = 1
    fun popSmallest(): Int {
        while(visited[cur]) {
            cur++
        }
        visited[cur] = true
        return cur++
    }

    fun addBack(num: Int) {
        visited[num] = false

        if(cur > num) {
            cur = num
        }
    }

}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */
Console

