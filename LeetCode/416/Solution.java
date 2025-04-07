class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[10001];
        dp[0] = true;
        for(int num : nums) {
            for(int j=10000;j>=num;j--) {
                dp[j] = dp[j] || dp[j-num];
            }
            if(dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
}
