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
    bool isCompleteTree(TreeNode* root) {
        queue<TreeNode*> q;
        
        q.push(root);
        
        bool result = true;
        bool nullCheck = false;
        
        while(!q.empty()) {
            TreeNode* top = q.front();
            q.pop();
            
            if(top == NULL && nullCheck == false) {
                nullCheck = true;
                continue;
            }
            else if(top == NULL) {
                continue;
            }
            else if(top != NULL && nullCheck == true) {
                result = false;
                break;
            }
            
            q.push(top->left);
            q.push(top->right);
        }
        
        return result;
    }
};

