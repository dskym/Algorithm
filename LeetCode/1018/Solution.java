class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = 0;
        List<Boolean> result = new ArrayList<>();
        for(int i=0;i<nums.length;++i) {
            n = (n * 2 + nums[i]) % 5;
            result.add(n % 5 == 0);
        }
        return result;
    }
}
