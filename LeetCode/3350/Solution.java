class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int count = 1;
        int prev = 0;

        int result = 0;
        for(int i=1;i<n;++i) {
            if(nums.get(i-1) < nums.get(i)) {
                count++;
            } else {
                prev = count;
                count = 1;
            }
            result = Math.max(result, Math.min(prev, count));
            result = Math.max(result, count / 2);
        }
        return result;
    }
}
