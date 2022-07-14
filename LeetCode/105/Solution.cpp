class Solution {
public:
    int index = 0;
    TreeNode* build(int start, int end, vector<int>& preorder, vector<int>& inorder) {
        if(start >= end)
            return NULL;
        
        int val = preorder[index++];
        TreeNode* node = new TreeNode(val, NULL, NULL);
        for(int i=start;i<end;++i) {
            if(val == inorder[i]) {
                node->left = build(start, i, preorder, inorder);
                node->right = build(i+1, end, preorder, inorder);
                break;
            }
        }
        return node;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        return build(0, preorder.size(), preorder, inorder);
    }
};
