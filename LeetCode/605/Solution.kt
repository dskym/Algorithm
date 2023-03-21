class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if(flowerbed.size == 1 && n == 1 && flowerbed[0] == 0) {
            return true
        }

        var count = n
        for(i in 0 until flowerbed.size) {
            if(i-1 >= 0 && i+1 <= flowerbed.size-1 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0 && flowerbed[i] == 0) {
                count--
                flowerbed[i] = 1
            } else if(i == 0 && i+1 <= flowerbed.size-1 && flowerbed[i+1] == 0 && flowerbed[i] == 0) {
                count--
                flowerbed[i] = 1
            } else if(i == flowerbed.size-1 && i-1 >= 0 && flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                count--
                flowerbed[i] = 1
            }
        }
        return if (count <= 0) true else false
    }
}
