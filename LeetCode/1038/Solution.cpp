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
    int solve(TreeNode* root, int total) {
        if(root == NULL)
            return total;

        int right = solve(root->right, total);
        
        int here = right + root->val;
        
        root->val = here;
        
        int left = solve(root->left, here);
        
        return max(left, here);
    }
    
    TreeNode* bstToGst(TreeNode* root) {
        solve(root, 0);
        
        return root;
    }
};
