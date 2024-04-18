class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }

        int start = 0;
        int count = 0;

        while(start+nums[start] < nums.length-1) {
            int range = nums[start];
            int next = 0;
            int nextIndex = 0;
            for(int i=start;i<=start+range;++i) {
                if(next <= i+nums[i]) {
                    next = i+nums[i];
                    nextIndex = i;
                }
            }
            start = nextIndex;
            count++;
        }

        return count+1;
    }
}
