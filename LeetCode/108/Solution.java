class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length-1);
    }

    public TreeNode makeTree(int[] nums, int start, int end) {
        if(start == end) {
            return new TreeNode(nums[start]);
        } else if(start+1 == end) {
            if(nums[start] > nums[end]) {
                TreeNode left = new TreeNode(nums[end]);
                return new TreeNode(nums[start+1], left, null);
            } else {
                TreeNode left = new TreeNode(nums[start]);
                return new TreeNode(nums[start+1], left, null);
            }
        } else if(start+2 == end) {
            TreeNode left = new TreeNode(nums[start]);
            TreeNode right = new TreeNode(nums[end]);
            return new TreeNode(nums[start+1], left, right);
        }
        int mid = (start+end)/2;
        TreeNode left = makeTree(nums, start, mid-1);
        TreeNode right = makeTree(nums, mid+1, end);      
        TreeNode root = new TreeNode(nums[mid], left, right);
        return root;
    }
}
