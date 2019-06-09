/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int result = 0;
    
    int dfs(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        int left = dfs(root->left);
        int right = dfs(root->right);
        
        result += abs(left) + abs(right);
        
        return root->val + left + right - 1;
    }
    
    int distributeCoins(TreeNode* root) {
        dfs(root);

        return result;
    }
};
