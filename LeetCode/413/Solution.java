class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        for(int i=2;i<n;i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                dp[i] = dp[i-1]+1;
            }
        }

        int result = 0;
        for(int i=0;i<n;i++){
            result += dp[i];
        }
        return result;
    }
}
