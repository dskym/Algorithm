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
    bool solve(TreeNode* root, int base) {
        if(root == NULL)
            return true;
        
        if(root->val != base)
            return false;
        
        return solve(root->left, base) && solve(root->right, base);
    }
    
    bool isUnivalTree(TreeNode* root) {
        return solve(root, root->val);
    }
};
