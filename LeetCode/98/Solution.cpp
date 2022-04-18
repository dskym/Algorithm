class Solution {
public:
    vector<int> v;
    void inorder(TreeNode* node) {
        if(node == NULL)
            return;
        
        inorder(node->left);
        v.push_back(node->val);
        inorder(node->right);
    }
    bool isValidBST(TreeNode* root) {
        inorder(root);
        for(int i=0;i<v.size()-1;++i) {
            if(v[i] >= v[i+1])
                return false;
        }
        return true;
    }
};
