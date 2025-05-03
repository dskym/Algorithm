class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;
        for(int weight : weights) {
            start = Math.max(start, weight);
            end += weight;
        }

        int result = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start+end)/2;
            int count = 1;
            int temp = 0;
            for(int i=0;i<weights.length;++i) {
                if(temp + weights[i] > mid) {
                    if(temp > 0) {
                        count++;
                    }
                    temp = 0;
                }
                temp += weights[i];
            }

            if(count <= days) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
