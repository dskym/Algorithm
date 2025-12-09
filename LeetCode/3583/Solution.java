class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        int n = nums.length;

        int mod = 1000000007;

        for(int i=0;i<n;++i) {
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }

        int result = 0;
        for(int i=0;i<n;++i) {
            int l = left.getOrDefault(nums[i]*2, 0);
            left.put(nums[i], left.getOrDefault(nums[i], 0)+1);
            int r = count.getOrDefault(nums[i]*2, 0)-left.getOrDefault(nums[i]*2, 0);
            result = (int)(result + (long)l * r % mod) % mod;
        }
        return result % mod;
    }
}
