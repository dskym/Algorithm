class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=n-1;i>=2;--i) {
            for(int j=i-1;j>=1;--j) {
                for(int k=j-1;k>=0;--k) {
                    if(nums[j]+nums[k]>nums[i]) {
                        return nums[i]+nums[j]+nums[k];
                    }
                }
            }
        }
        return 0;
    }
}
