class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        
        int n = price.length;
        int start = 0;
        int end = price[n-1];
        int result = 0;

        while(start < end) {
            int mid = (start+end)/2;

            int count = 1;
            int base = price[0];
            for(int i=1;i<n;++i) {
                if(price[i]-base >= mid) {
                    count++;
                    base = price[i];
                }
            }

            if(count >= k) {
                start = mid+1;
            } else {
                end = mid;
            }

        }

        return start-1;
    }
}
