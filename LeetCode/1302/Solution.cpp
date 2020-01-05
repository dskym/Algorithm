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
    int getHeight(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        return max(getHeight(root->left), getHeight(root->right)) + 1;
    }
    
    int solve(TreeNode* root, int height) {
        if(root == NULL)
            return 0;
        
        if(height == 1)
            return root->val;
        
        int ret = 0;
        
        ret = solve(root->left, height-1) + solve(root->right, height-1);
        
        return ret;
    }
    
    int deepestLeavesSum(TreeNode* root) {
        int height = getHeight(root);
        
        return solve(root, height);
    }
};

