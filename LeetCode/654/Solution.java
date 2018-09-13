import java.util.*;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {        
        if(nums.length == 1)
            return new TreeNode(nums[0]);
        
        int temp = nums[0];
        int index = 0;
        
        for(int i=1;i<nums.length;++i) {
            if(temp < nums[i]) {
                temp = nums[i];
                index = i;
            }
        }
            
        TreeNode root = new TreeNode(temp);

        if(index > 0)
            root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, index));
        
        if(index < nums.length - 1)
            root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, index + 1, nums.length));
        
        return root;
    }
}
