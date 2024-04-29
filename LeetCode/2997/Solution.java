class Solution {
    public int minOperations(int[] nums, int k) {
        int temp = 0;
        for(int i=0;i<nums.length;++i) {
            temp ^= nums[i];
        }
        temp ^= k;
        int count = 0;
        while(temp != 0) {
            if(temp % 2 == 1) {
                count++;
            }
            temp = temp >> 1;
        }
        return count;
    }
}

