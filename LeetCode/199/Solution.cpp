class Solution {
public:
    vector<int> ret;
    void solve(TreeNode* root, int depth) {
        if(root == NULL)
            return;
        if(depth > ret.size()) {
            ret.push_back(root->val);
        }
        solve(root->right, depth+1);
        solve(root->left, depth+1);
    }
    vector<int> rightSideView(TreeNode* root) {
        solve(root, 1);
        return ret;
    }
};
