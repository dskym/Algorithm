class Solution {
    public int findNumbers(int[] nums) {
        int result = 0;
        for(int num : nums) {
            if(count(num) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private int count(int num) {
        int result = 0;
        while(num != 0) {
            result++;
            num /= 10;
        }
        return result;
    }
}
