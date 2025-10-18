class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Set<Integer> s = new HashSet<>();

        Arrays.sort(nums);

        int prev = nums[0]-k;
        int result = 1;
        for(int i=1;i<nums.length;++i) {
            int l = Math.max(nums[i]-k, prev+1);
            if(l <= nums[i]+k) {
                result++;
                prev = l;
            }
        }
        return result;
    }
}
