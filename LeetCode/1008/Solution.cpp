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
    TreeNode* makeTree(vector<int>& preorder, int start, int end) {
        if(start > end)
            return NULL;
        
        if(start == end)
            return new TreeNode(preorder[start]);
                
        TreeNode* root = new TreeNode(preorder[start]);
        
        int mid = start + 1;
        
        while(mid <= end) {
            if(preorder[mid] > preorder[start])
                break;

            mid++;
        }
        
        root->left = makeTree(preorder, start + 1, mid - 1);
        root->right = makeTree(preorder, mid, end);
        
        return root;        
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        TreeNode* root = makeTree(preorder, 0, preorder.size() - 1);
        
        return root;
    }
};
