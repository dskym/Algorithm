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
    int deepestValue(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        int left = 1;
        int right = 1;
        
        if(root->left)
            left = deepestValue(root->left) + 1;
        
        if(root->right)
            right = deepestValue(root->right) + 1;
        
        return max(left, right);
    }
    
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        int left = 0;
        int right = 0;
        
        if(root->left)
            left = deepestValue(root->left);
        
        if(root->right)
            right = deepestValue(root->right);
                
        if(left == right)
            return root;
        else if(left > right)
            return subtreeWithAllDeepest(root->left);
        else
            return subtreeWithAllDeepest(root->right);
    }
};
