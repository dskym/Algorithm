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
    TreeNode* invert(TreeNode* root) {
        TreeNode* newNode = new TreeNode(root->val);
        
        if(root->left != NULL)
            newNode->right = invert(root->left);
        
        if(root->right != NULL)
            newNode->left = invert(root->right);

        return newNode;
    }

    TreeNode* invertTree(TreeNode* root) {
        if(root == NULL)
            return NULL;
        else
            return invert(root);
    }
};
