class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift : gifts) {
            pq.add(gift);
        }

        for(int i=0;i<k;++i) {
            int temp = pq.poll();
            pq.add((int)Math.sqrt(temp));
        }

        long result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }
        return result;
    }
}
