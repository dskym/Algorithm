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
private:
    vector<int> result;
public:
    vector<int> largestValues(TreeNode* root) {
        solve(root, 0);
        
        return result;
    }
    
    void solve(TreeNode* root, int depth) {
        if(root == NULL)
            return;
        
        if(result.size() == depth) {
            result.push_back(root->val);
        } else {
            if(result[depth] < root->val)
                result[depth] = root->val;
        }
        
        solve(root->left, depth + 1);
        solve(root->right, depth + 1);
    }
};
