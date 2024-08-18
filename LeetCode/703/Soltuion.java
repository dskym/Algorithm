class KthLargest {
    Queue<Integer> pq = new PriorityQueue<>();
    int base = 0;

    public KthLargest(int k, int[] nums) {
        base = k;

        for(int i=0;i<nums.length;++i) {
            pq.add(nums[i]);
        }
        for(int i=0;i<nums.length-k;++i) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        if(pq.size() < base) {
            pq.add(val);
        } else if(pq.peek() < val) {
            pq.add(val);
            pq.poll();
        }
        return pq.peek();
    }
}
