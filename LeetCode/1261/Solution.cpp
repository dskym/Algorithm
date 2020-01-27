/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class FindElements {
public:
    TreeNode* temp = NULL;
    
    FindElements(TreeNode* root) {
        temp = root;
        
        solve(root, 0);
    }
    
    void solve(TreeNode* root, int val) {
        if(root == NULL)
            return;
        
        root->val = val;
        
        if(root->left)
            solve(root->left, 2*val+1);

        if(root->right)
            solve(root->right, 2*val+2);
    }
    
    bool find(int target) {
        TreeNode* root = temp;
        
        return findNode(root, target);
    }
    
    bool findNode(TreeNode* root, int target) {
        if(root == NULL)
            return false;
        
        if(root->val == target)
            return true;
        
        return findNode(root->left, target) | findNode(root->right, target);        
    }
};

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements* obj = new FindElements(root);
 * bool param_1 = obj->find(target);
 */
