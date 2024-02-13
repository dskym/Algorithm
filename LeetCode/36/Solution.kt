class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for(i in 0 until 9) {
            val visited = BooleanArray(10) { false }
            for(j in 0 until 9) {
                if(board[i][j] == '.') {
                    continue
                }
                if(visited[Character.getNumericValue(board[i][j])]) {
                    return false
                }
                visited[Character.getNumericValue(board[i][j])] = true
            }
        }

        for(i in 0 until 9) {
            val visited = BooleanArray(10) { false }
            for(j in 0 until 9) {
                if(board[j][i] == '.') {
                    continue
                }
                if(visited[Character.getNumericValue(board[j][i])]) {
                    return false
                }
                visited[Character.getNumericValue(board[j][i])] = true
            }
        }

        for(a in 0 until 3) {
            for(b in 0 until 3) {
                val visited = BooleanArray(10) { false }
                for(c in 0 until 3) {
                    for(d in 0 until 3) {
                        if(board[a*3+c][b*3+d] == '.') {
                            continue
                        }
                        if(visited[Character.getNumericValue(board[a*3+c][b*3+d])]) {
                            return false
                        }
                        visited[Character.getNumericValue(board[a*3+c][b*3+d])] = true
                    }                    
                }
            }
        }

        return true
    }
}
