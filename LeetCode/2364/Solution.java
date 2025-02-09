class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i) {
            Integer c = map.getOrDefault(nums[i]-i, 0)+1;
            map.put(nums[i]-i, c);
        }

        long result = 0;
        for(int i=0;i<nums.length;++i) {
            result += nums.length-map.get(nums[i]-i);
        }
        return result/2;
    }
}
