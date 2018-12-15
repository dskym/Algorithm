class Solution {
public:
    int traverse(TreeNode* node, int L, int R) {
        if(node == NULL)
            return 0;
                
        int sum = 0;
        
        if(node->val >= L && node->val <= R)
            sum += node->val;

        if(node->left != NULL)
            sum += traverse(node->left, L, R);
        
        if(node->right != NULL)
            sum += traverse(node->right, L, R);
            
        return sum;
    }
    
    int rangeSumBST(TreeNode* root, int L, int R) {
        return traverse(root, L, R);
    }
};
