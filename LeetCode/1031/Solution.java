class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i=1;i<=n;++i) {
            prefix[i] = nums[i-1] + prefix[i-1];
        }

        int result = 0;
        for(int i=firstLen-1;i<n;++i) {
            int s1 = i-firstLen+1;
            int e1 = i;

            for(int j=secondLen-1;j<n;++j) {
                int s2 = j-secondLen+1;
                int e2 = j;

                if(s2 > e1 || s1 > e2) {
                    
                    result = Math.max(result, prefix[e1+1]-prefix[s1]+prefix[e2+1]-prefix[s2]);
                }
            }
        }
        return result;
    }
}
