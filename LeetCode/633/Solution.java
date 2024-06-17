class Solution {
    public boolean judgeSquareSum(int c) {
        long[] arr = new long[60000];
        int sqrt = (int)Math.pow(c, 0.5);
        for(int i=0;i<=sqrt;++i) {
            arr[i] = i*i;
        }
        for(int i=0;i<=sqrt;++i) {
            int start = 0;
            int end = sqrt;
            int target = c - i*i;
            while(start <= end) {
                int mid = (start+end)/2;
                if(arr[mid] > target) {
                    end = mid-1;
                } else if(arr[mid] < target) {
                    start = mid+1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
