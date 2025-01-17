class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int result = 0;
        for(int num : derived) {
            result ^= num;
        }
        return result == 0;
    }
}


