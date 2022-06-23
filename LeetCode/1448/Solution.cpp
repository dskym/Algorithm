class Solution {
public:
    int dfs(TreeNode* root, int m) {
        if(root == NULL)
            return 0;
        
        int left = 0, right = 0;
        left = dfs(root->left, max(m, root->val));
        right = dfs(root->right, max(m, root->val));
        
        if(root->val >= m)
            return left + right + 1;

        return left+right;
    }
    int goodNodes(TreeNode* root) {
        return dfs(root, root->val);
    }
};
