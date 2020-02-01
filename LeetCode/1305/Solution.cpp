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
    void solve(TreeNode* root, vector<int>& r) {
        if(root == NULL)
            return;
        
        solve(root->left, r);
        r.push_back(root->val);
        solve(root->right, r);
    }
    
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> ret;

        vector<int> r1, r2;
        int index1 = 0, index2 = 0;
        
        solve(root1, r1);
        solve(root2, r2);
        
        while(index1 < r1.size() && index2 < r2.size()) {
            if(r1[index1] <= r2[index2])
                ret.push_back(r1[index1++]);
            else
                ret.push_back(r2[index2++]);
        }
        
        while(index1 < r1.size())
            ret.push_back(r1[index1++]);

        while(index2 < r2.size())
            ret.push_back(r2[index2++]);
        
        return ret;
    }
};
