class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = 1000000000;
        int end = 1;

        for(int i=0;i<bloomDay.length;++i) {
            if(bloomDay[i] < start) {
                start = bloomDay[i];
            }
            if(bloomDay[i] > end) {
                end = bloomDay[i];
            }
        }

        int result = 1000000001;
        while(start <= end) {
            int mid = (start+end)/2;
            int count = 0;

            int temp = k;
            for(int i=0;i<bloomDay.length;++i) {
                if(bloomDay[i] <= mid) {
                    temp--;
                } else {
                    temp = k;
                }
                if(temp == 0) {
                    temp = k;
                    count++;
                }
            }

            if(count >= m) {
                end=mid-1;
                result = Math.min(result, mid);
            } else {
                start=mid+1;
            }
        }

        return (result == 1000000001) ? -1 : result;
    }
}
