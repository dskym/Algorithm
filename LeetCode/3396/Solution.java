class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i=0;i<n;i+=3) {
            Set<Integer> set = new HashSet<>();
            boolean flag = true;
            for(int j=i;j<n;++j) {
                if(set.contains(nums[j])) {
                    flag = false;
                    break;
                }
                set.add(nums[j]);
            }
            if(flag) {
                return result;
            }
            result++;
        }
        return result;
    }
}
