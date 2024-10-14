class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int num : nums) {
            pq.add(num);
        }
        
        long result = 0;
        for(int i=0;i<k;++i) {
            int temp = pq.poll();
            result += temp;
            pq.add((temp+2)/3);
        }
        return result;
    }
}
