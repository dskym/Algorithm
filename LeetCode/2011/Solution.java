class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int result = 0;
        for(String operation: operations) {
            if(operation.charAt(0) == '-' || operation.charAt(2) == '-') {
                result--;
            } else {
                result++;
            }
        }
        return result;
    }
}
