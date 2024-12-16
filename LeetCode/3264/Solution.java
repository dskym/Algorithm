class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        for(int i=0;i<nums.length;++i) {
            pq.add(new int[]{nums[i], i});
        }

        for(int i=0;i<k;++i) {
            int[] node = pq.poll();
            pq.add(new int[]{node[0]*multiplier, node[1]});
        }

        int[] result = new int[nums.length];
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            result[node[1]] = node[0];
        }
        return result;
    }
}
