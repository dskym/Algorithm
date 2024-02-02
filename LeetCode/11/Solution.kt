class Solution {
    fun maxArea(height: IntArray): Int {
        var result = 0
        var left = 0
        var right = height.size-1
        while(left < right) {
            val area = (right-left) * Math.min(height[left], height[right])
            result = if(result < area) area else result
            if(height[left] > height[right]) {
                right--
            } else {
                left++
            }
        }
        return result
    }
}
