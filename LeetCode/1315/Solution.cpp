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
    int solve(TreeNode* root, int depth) {
        if(root == NULL)
            return 0;
        
        if(depth == 0)
            return root->val;

        return solve(root->left, depth-1) + solve(root->right, depth-1);
    }
    
    int traverse(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        int ret = 0;
        
        if(root->val % 2 == 0)
            ret += solve(root, 2);
        
        ret += traverse(root->left);
        ret += traverse(root->right);

        return ret;
    }
    
    int sumEvenGrandparent(TreeNode* root) {
        return traverse(root);
    }
};
