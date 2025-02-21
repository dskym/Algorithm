class FindElements {

    private Set<Integer> set;
    private TreeNode root;

    public FindElements(TreeNode root) {
        this.set = new HashSet<>();

        solve(root, 0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }

    private void solve(TreeNode root, int temp) {
        if(root == null) {
            return;
        }

        set.add(temp);

        solve(root.left, temp*2+1);
        solve(root.right, temp*2+2);
    }
}
