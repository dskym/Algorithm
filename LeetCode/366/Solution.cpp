class Solution {
public:
    vector<vector<int>> ret;
    int solve(TreeNode* root) {

        int leftDepth = 0;
        if(root->left != NULL)
            leftDepth = solve(root->left) + 1;
        
        int rightDepth = 0;
        if(root->right != NULL)
            rightDepth = solve(root->right) + 1;
        
        int depth = max(leftDepth, rightDepth);
        
        if(ret.size() == depth) {
            ret.push_back({root->val});
        } else {
            ret[depth].push_back(root->val);
        }

        return depth;
    }
    vector<vector<int>> findLeaves(TreeNode* root) {
        solve(root);
        return ret;
    }
};
