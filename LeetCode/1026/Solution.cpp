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
    int solve(TreeNode* root, int maxValue, int minValue) {
        if(root == NULL)
            return 0;
        
        int result = 0;

        result = max(result, abs(minValue - root->val));
        result = max(result, abs(maxValue - root->val));
        result = max(result, solve(root->left, max(maxValue, root->val), min(minValue, root->val)));
        result = max(result, solve(root->right, max(maxValue, root->val), min(minValue, root->val)));
        
        return result;
    }
    
    int maxAncestorDiff(TreeNode* root) {
        return solve(root, root->val, root->val);
    }
};
