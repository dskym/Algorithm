class Solution {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> m = new HashMap<>();

        Arrays.sort(nums);

        int result = -1;
        for(int i=0;i<n;++i) {
            int sqrt = (int)Math.sqrt(nums[i]);

            if(sqrt*sqrt == nums[i] && m.containsKey(sqrt)) {
                m.put(nums[i], m.get(sqrt)+1);
                result = Math.max(result, m.get(nums[i]));
            } else {
                m.put(nums[i], 1);
            }
        }

        return result;
    }
}
