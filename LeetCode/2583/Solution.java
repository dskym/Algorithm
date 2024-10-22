class Solution {
    Map<Integer, Long> levelSum = new HashMap<>();
    public long kthLargestLevelSum(TreeNode root, int k) {
        calculate(root, 1);

        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(b, a));
        for(Integer level : levelSum.keySet()) {
            pq.add(levelSum.get(level));
        }
        for(int i=0;i<k-1;++i) {
            if(pq.isEmpty()) {
                return -1;
            }
            pq.poll();
        }
        if(pq.isEmpty()) {
            return -1;
        }
        return pq.poll();
    }

    private void calculate(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        Long sum = levelSum.getOrDefault(level, 0L);
        levelSum.put(level, sum+root.val);

        calculate(root.left, level+1);
        calculate(root.right, level+1);
    }
}
