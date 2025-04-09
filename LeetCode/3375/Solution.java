class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        
        if(nums[0] < k) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int result = set.size();
        if(nums[0] == k) {
            result--;
        }
        return result;
    }
}
