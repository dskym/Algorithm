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
    TreeNode* solve(TreeNode* root, int v, int depth, int d) {
        if(depth + 1 == d) {
            if(root->left != NULL) {
                TreeNode* temp = new TreeNode(v);
                temp->left = root->left;                
                root->left = temp;
            } else {
                root->left = new TreeNode(v);
            }
            
            if(root->right != NULL) {
                TreeNode* temp = new TreeNode(v);
                temp->right = root->right;                
                root->right = temp;
            } else {
                root->right = new TreeNode(v);
            }
                        
            return root;
        }
        
        if(root->left)
            root->left = solve(root->left, v, depth + 1, d);

        if(root->right)
            root->right = solve(root->right, v, depth + 1, d);

        return root;
    }
    
    TreeNode* addOneRow(TreeNode* root, int v, int d) {
        if(d == 1) {
            TreeNode* newRoot = new TreeNode(v);
            newRoot->left = root;
            root = newRoot;
            
            return root;
        } else
            return solve(root, v, 1, d);
    }
};
