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
    TreeNode* solve(TreeNode* t1, TreeNode* t2) {
        TreeNode* root;
        
        if(t1 != NULL && t2 != NULL) {
            root = new TreeNode(t1->val + t2->val);
            
            root->left = solve(t1->left, t2->left);
            root->right = solve(t1->right, t2->right);
        }
        else if(t1 != NULL) {
            root = new TreeNode(t1->val);

            root->left = solve(t1->left, NULL);
            root->right = solve(t1->right, NULL);
        }
        else if(t2 != NULL) {
            root = new TreeNode(t2->val);
            
            root->left = solve(NULL, t2->left);
            root->right = solve(NULL, t2->right);
        }
        else {
            return NULL;
        }
                
        return root;
    }
    TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
        return solve(t1, t2);
    }
};
