class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val rowCount = Array<IntArray>(matrix.size) {IntArray(matrix[0].size)}

        for(i in 0 until matrix.size) {
            var index = -1
            val stack = Stack<Int>()
            for(j in 0 until matrix[i].size) {
                if(matrix[i][j] == '1') {
                    stack.add(j)
                } else {
                    var count = 1
                    while(stack.isNotEmpty()) {
                        rowCount[i][stack.peek()] = count++
                        stack.pop()
                    }
                    index = j
                }
            }
            var count = 1
            while(stack.isNotEmpty()) {
                rowCount[i][stack.peek()] = count++
                stack.pop()
            }
        }

        var result = 0
        for(i in 0 until matrix.size) {
            for(j in 0 until matrix[i].size) {
                if(matrix[i][j] == '1') {
                    var index = i
                    var height = rowCount[i][j]
                    while(index < matrix.size) {
                        if(matrix[index][j] == '1') {
                            height = min(height, rowCount[index][j])
                            result = max(result, height*(index-i+1))
                        } else {
                            break
                        }
                        index++
                    }
                }
            }
        }

        return result
    }
}

