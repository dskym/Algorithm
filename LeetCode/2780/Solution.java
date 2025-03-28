class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.size();++i) {
            int count = map.getOrDefault(nums.get(i), 0)+1;
            map.put(nums.get(i), count);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<nums.size()-1;++i) {
            int count = map.get(nums.get(i))-1;
            map.put(nums.get(i), count);

            int count2 = map2.getOrDefault(nums.get(i), 0)+1;
            map2.put(nums.get(i), count2);

            if(map.get(nums.get(i))*2>nums.size()-i-1 && map2.get(nums.get(i))*2>i+1) {
                return i;
            }
        }

        return -1;
    }
}
