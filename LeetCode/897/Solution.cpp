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
    TreeNode* result = NULL;
    
    void inorderTraverse(TreeNode* root) {
        if(root == NULL)
            return;
        
        inorderTraverse(root->left);
        
        if(result == NULL)
            result = new TreeNode(root->val);
        else {            
            TreeNode* t = result;
            
            while(t->right)
                t = t->right;
            
            t->right = new TreeNode(root->val);
        }
        
        inorderTraverse(root->right);
    }
    
    TreeNode* increasingBST(TreeNode* root) {
        inorderTraverse(root);
        
        return result;
    }
};
