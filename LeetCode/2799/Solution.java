class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int start = 0;
        int end = 0;
        Map<Integer, Integer> counter = new HashMap<>();
        
        int result = 0;
        while(end < n) {
            counter.put(nums[end], counter.getOrDefault(nums[end], 0)+1);
            while(counter.size() == set.size()) {
                counter.put(nums[start], counter.get(nums[start])-1);
                if(counter.get(nums[start]) == 0) {
                    counter.remove(nums[start]);
                }
                result += n-end;
                start++;
            }
            end++;
        }
        return result;
    }
}
