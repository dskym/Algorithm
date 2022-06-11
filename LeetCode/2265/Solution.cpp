class Solution {
public:
    int result = 0;
    int updateTree(TreeNode* root) {
        int left = 0, right = 0;
        int count = 1;
        if(root->left != NULL) {
            count += updateTree(root->left);
            left = root->left->val;
        }
        if(root->right != NULL) {
            count += updateTree(root->right);
            right = root->right->val;
        }
        if(root->val == (left + right + root->val) / count)
            result++;
        root->val = left + right + root->val;
        return count;
    }
    int averageOfSubtree(TreeNode* root) {
        updateTree(root);
        return result;
    }
};
