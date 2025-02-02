class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;++i) {
            boolean flag = true;
            for(int j=0;j<n-1;++j) {
                int a = (i+j) % n;
                int b = (i+j+1) % n;
                if(nums[a] > nums[b]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return true;
            }
        }
        return false;
    }
}
