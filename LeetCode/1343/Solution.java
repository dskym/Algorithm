class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for(int i=0;i<k;++i) {
            sum += arr[i];
        }

        int n = arr.length;

        int result = 0;
        for(int i=k;i<n;++i) {
            if(sum / k >= threshold) {
                result++;
            }
            sum += arr[i];
            sum -= arr[i-k];
        }
        if(sum / k >= threshold) {
            result++;
        }
        return result;
    }
}
