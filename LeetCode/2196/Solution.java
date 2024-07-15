class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> indegrees = new HashSet<>();

        Map<Integer, TreeNode> m = new HashMap<>();
        for(int i=0;i<descriptions.length;++i) {
            indegrees.add(descriptions[i][1]);
            if(m.containsKey(descriptions[i][0])) {
                TreeNode child = m.getOrDefault(descriptions[i][1], new TreeNode(descriptions[i][1]));
                if(!m.containsKey(descriptions[i][1])) {
                    m.put(descriptions[i][1], child);
                }
                if(descriptions[i][2] == 1) {
                    m.get(descriptions[i][0]).left = child;
                } else {
                    m.get(descriptions[i][0]).right = child;
                }
            } else {
                TreeNode child = m.getOrDefault(descriptions[i][1], new TreeNode(descriptions[i][1]));
                if(!m.containsKey(descriptions[i][1])) {
                    m.put(descriptions[i][1], child);
                }
                if(descriptions[i][2] == 1) {
                    m.put(descriptions[i][0], new TreeNode(descriptions[i][0], child, null));
                } else {
                    m.put(descriptions[i][0], new TreeNode(descriptions[i][0], null, child));
                }
            }
        }
        for(int i=0;i<descriptions.length;++i) {
            if(!indegrees.contains(descriptions[i][0])) {
                return m.get(descriptions[i][0]);
            }
        }
        return null;
    }
}
