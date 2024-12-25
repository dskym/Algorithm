class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            int temp = Integer.MIN_VALUE;
            for(int i=0;i<size;++i) {
                TreeNode node = q.poll();
                temp = Math.max(temp, node.val);
                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
