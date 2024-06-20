class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int start = 1;
        int end = position[position.length-1]-start;

        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;

            int temp = 1;
            int t = position[0];
            for(int i=1;i<position.length;++i) {
                if(position[i]-t >= mid) {
                    t = position[i];
                    temp++;
                }
            }

            if(temp >= m) {
                start = mid+1;
                result = Math.max(result, mid);
            } else {
                end = mid-1;
            }             
        }
        return result;
    }
}
