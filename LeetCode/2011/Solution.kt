class Solution {
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var ret = 0
        for(operation in operations) {
            if(operation.equals("--X") || operation.equals("X--")) {
                ret--
            } else {
                ret++
            }
        }
        return ret
    }
}
