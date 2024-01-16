class RandomizedSet() {

    val m = mutableMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean {
        if(`val` in m) {
            return false
        }
        m.put(`val`, 1)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if(`val` !in m) {
            return false
        }
        m.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        val size = m.keys.size
        return m.keys.toList()[(0..size-1).random()]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
