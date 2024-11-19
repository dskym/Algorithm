class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        long sum = 0;

        for(int i=0;i<k;++i) {
            sum += nums[i];
            Integer cnt = counter.getOrDefault(nums[i], 0);
            counter.put(nums[i], cnt+1);
        }

        long result = 0;
        for(int i=k;i<nums.length;++i) {
            if(counter.size() == k) {
                result = Math.max(result, sum);
            }

            sum += nums[i];
            sum -= nums[i-k];

            Integer cnt1 = counter.getOrDefault(nums[i-k], 0);
            if(cnt1 == 1) {
                counter.remove(nums[i-k]);
            } else {
                counter.put(nums[i-k], cnt1-1);
            }

            Integer cnt2 = counter.getOrDefault(nums[i], 0);
            counter.put(nums[i], cnt2+1);
        }

        if(counter.size() == k) {
            result = Math.max(result, sum);
        }

        return result;
    }
}
