/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void traverse(TreeNode* root, int target) {
        if(root == NULL)
            return;
                
        if(root->left)
            traverse(root->left, target);

        if(root->right)
            traverse(root->right, target);
        
        if(root->left != NULL && root->left->val == 0)
            root->left = NULL;
        if(root->right != NULL &&  root->right->val == 0)
            root->right = NULL;
            
        if(root->val == target && root->left == NULL && root->right == NULL) {
            root->val = 0;
        }
    }
    TreeNode* removeLeafNodes(TreeNode* root, int target) {
        traverse(root, target);

        if(root->val == 0)
            return NULL;
        else
            return root;
    }
};
