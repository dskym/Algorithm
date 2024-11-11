class Solution {
    public boolean primeSubOperation(int[] nums) {
        boolean[] prime = new boolean[1001];
        for(int i=2;i<=1000;++i) {
            prime[i]=true;
        }
        for(int i=2;i<=1000;++i) {
            for(int j=i*i;j<=1000;j+=i) {
                prime[j] = false;
            }
        }

        boolean result = true;
        for(int i=nums.length-1;i>0;--i) {
            if(nums[i-1] >= nums[i]) {
                for(int j=2;j<=nums[i-1];++j) {
                    if(prime[j] && nums[i-1]-j < nums[i] && j < nums[i-1]) {
                        nums[i-1] = nums[i-1]-j;
                        break;
                    }
                }
            }
        }

        for(int i=nums.length-1;i>0;--i) {
            if(nums[i-1] >= nums[i]) {
                result = false;
            }
        }
        return result;
    }
}
