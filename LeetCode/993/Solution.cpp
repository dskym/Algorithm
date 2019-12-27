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
    bool isCousins(TreeNode* root, int x, int y) {
        queue<pair<pair<TreeNode*, int>, int>> q;
        
        q.push({{root, 0}, 0});
        
        int hx, px;
        int hy, py;
        
        while(!q.empty()) {
            auto t = q.front();
            q.pop();
            
            TreeNode* node = t.first.first;
            int height = t.first.second;
            int parent = t.second;
            
            if(node->val == x) {
                hx = height;
                px = parent;
            } else if(node->val == y) {
                hy = height;
                py = parent;
            }
            
            if(node->left != NULL)
                q.push({{node->left, height+1}, node->val});

            if(node->right != NULL)
                q.push({{node->right, height+1}, node->val});
        }
        
        if(hx != hy)
            return false;
        
        if(px == py)
            return false;
        
        return true;
    }
};
