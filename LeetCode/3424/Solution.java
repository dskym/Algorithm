class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        long result = 0;
        for(int i=0;i<arr.length;++i) {
            result += Math.abs(arr[i]-brr[i]);
        }

        Arrays.sort(arr);
        Arrays.sort(brr);

        long temp = k;
        for(int i=0;i<arr.length;++i) {
            temp += Math.abs(arr[i]-brr[i]);
        }

        return Math.min(result, temp);
    }
}
