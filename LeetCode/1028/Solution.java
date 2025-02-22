class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = new TreeNode();
        Stack<Pair<Integer, TreeNode>> stack = new Stack<>();

        int depth = 0;
        int index = 0;
        while(index < traversal.length()) {
            if(traversal.charAt(index) != '-') {
                int temp = 0;
                while(index < traversal.length() && traversal.charAt(index) != '-') {
                    temp = 10 * temp + traversal.charAt(index)-'0';
                    index++;
                }
                while(!stack.isEmpty() && stack.peek().getKey() >= depth) {
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    TreeNode newNode = new TreeNode(temp);
                    TreeNode node = stack.peek().getValue();
                    if(node.left == null) {
                        node.left = newNode;
                    } else {
                        node.right = newNode;
                    }
                    stack.push(new Pair(depth, newNode));
                } else {
                    root = new TreeNode(temp);
                    stack.push(new Pair(depth, root));
                }
                depth = 0;
            } else {
                while(index < traversal.length() && traversal.charAt(index) == '-') {
                    depth++;
                    index++;
                }
            }
        }
        return root;
    }
}
