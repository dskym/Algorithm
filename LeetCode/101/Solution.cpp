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
    bool solve(TreeNode* leftNode, TreeNode* rightNode) {
        if(leftNode == NULL && rightNode == NULL) {
            return true;
        }

        if(leftNode != NULL && rightNode != NULL && leftNode->val == rightNode->val) {
            return solve(leftNode->left, rightNode->right) && solve(leftNode->right, rightNode->left);
        }

        return false;
    }

    bool isSymmetric(TreeNode* root) {
        return solve(root->left, root->right);
    }
};
