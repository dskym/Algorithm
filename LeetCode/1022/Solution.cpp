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
    int binary(string s) {
        int r = 0;
        
        int base = 1;
        
        for(int i=s.size()-1;i>=0;--i) {
            if(s[i] == '1')
                r += base;
            
            base *= 2;
        }
        
        return r;
    }
    
    int sum = 0;
    
    void solve(TreeNode* root, string s) {
        if(root == NULL)
            return;
        
        if(root->val == 1)
            s += "1";
        else
            s += "0";
        
        if(root->left == NULL && root->right == NULL)
            sum += binary(s);
            
        solve(root->left, s);
        solve(root->right, s);
    }
    
    int sumRootToLeaf(TreeNode* root) {
        solve(root, "");
        
        return sum;
    }
};
