class Solution {
    public int minimumOperations(TreeNode root) {
        int result = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int[] levels = new int[size];

            for(int i=0;i<size;++i) {
                TreeNode node = q.poll();
                levels[i] = node.val;

                if(node.left != null) {
                    q.add(node.left);
                }
                if(node.right != null) {
                    q.add(node.right);
                }
            }

            Map<Integer, Integer> m = new HashMap<>();
            for(int i=0;i<size;++i) {
                m.put(levels[i], i);
            }

            int[] target = levels.clone();
            Arrays.sort(target);

            for(int i=0;i<size;++i) {
                if(target[i] != levels[i]) {
                    result++;

                    int c = m.get(target[i]);
                    m.put(levels[i], c);
                    levels[c] = levels[i];
                }
            }
        }

        return result;
    }
}
