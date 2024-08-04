class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] temp = new int [n*(n+1)/2];

        int index = 0;
        for(int i=0;i<n;++i) {
            int t = 0;
            for(int j=i;j<n;++j) {
                t = (t + nums[j]) % 1000000007;
                temp[index++] = t;
            }
        }

        Arrays.sort(temp);

        int result = 0;
        for(int i=left;i<=right;++i) {
            result = (result + temp[i-1]) % 1000000007;
        }
        return result;
    }
}
