class Solution {
public:
    int dfs(TreeNode* root, int sum) {
        if(root->left == NULL && root->right == NULL) {
            return 10 * sum + root->val;
        }
        
        int left = 0, right = 0;
        if(root->left != NULL) {
            left = dfs(root->left, 10 * sum + root->val);
        }
        if(root->right != NULL) {
            right = dfs(root->right, 10 * sum + root->val);
        }
        
        return left + right;
    }
    int sumNumbers(TreeNode* root) {
        return dfs(root, 0);
    }
};
