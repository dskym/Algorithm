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
    vector<int> ret1;
    vector<int> ret2;
    void inorder(TreeNode* root, vector<int>& ret) {
        if(!root) {
            return;
        }
        inorder(root->left, ret);
        if(root->left == NULL && root->right == NULL) {
            ret.push_back(root->val);
        }
        inorder(root->right, ret);
    }
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        inorder(root1, ret1);
        inorder(root2, ret2);
        if(ret1.size() != ret2.size())
            return false;
        for(int i=0;i<min(ret1.size(), ret2.size());++i) {
            if(ret1[i] != ret2[i])
            return false;
        }
        return true;
    }
};
