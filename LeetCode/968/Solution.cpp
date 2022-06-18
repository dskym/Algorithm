class Solution {
public:
    int solve(TreeNode* root, TreeNode* parent) {
        int left = 0, right = 0;
        int count = 0;
        
        if(root->left != NULL) {
            left = solve(root->left, root);
        }
        
        if(root->right != NULL) {
            right = solve(root->right, root);
        }
        
        if((root->left != NULL && root->left->val == 0) || (root->right != NULL && root->right->val == 0)) {
            if(parent != NULL)
                parent->val = 1;
            root->val = 1;
            if(root->left != NULL)
                root->left->val = 1;
            if(root->right != NULL)
                root->right->val = 1;
            count++;
        }
        
        if(parent == NULL && root->val == 0)
            count++;
        
        return left + right + count;
    }
    int minCameraCover(TreeNode* root) {
        if(root == NULL) {
            return 0;
        } else if(root->left == NULL && root->right == NULL) {
            return 1;
        }
        return solve(root, NULL);
    }
};
