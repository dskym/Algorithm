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
    string pre(TreeNode* t) {
        if(t == NULL)
            return "";
        
        string temp = "";
        
        temp += to_string(t->val);

        if(t->left == NULL && t->right == NULL)
            return temp;

        if(t->left != NULL) {
            temp += "(";
            temp += pre(t->left);
            temp += ")";
        } else {
            temp += "()";
        }

        if(t->right != NULL) {        
            temp += "(";
            temp += pre(t->right);
            temp += ")";
        }
        
        return temp;
    }
    
    string tree2str(TreeNode* t) {
        return pre(t);
    }
};
