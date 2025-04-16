class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int start = 0;
        int end = 0;
        int n = nums.length;

        long result = 0;
        int pairCount = 0;
        while(end < n) {
            int cnt = counter.getOrDefault(nums[end], 0);
            pairCount += cnt;
            counter.put(nums[end], cnt+1);

            while(pairCount >= k) {
                result += n-end;
                cnt = counter.getOrDefault(nums[start], 0)-1;
                counter.put(nums[start], cnt);
                pairCount -= cnt;
                start++;
            }
            end++;
        }
        return result;
    }
}
