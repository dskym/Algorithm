/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class BSTIterator {
public:
    stack<TreeNode*> s;    
    BSTIterator(TreeNode* root) {
        if(root->right != NULL)
            s.push(root->right);
        
        s.push(root);
        
        if(root->left != NULL)
            s.push(root->left);   
        
        root->left = NULL;
        root->right = NULL;
    }
    
    int next() {
        while(true) {            
            TreeNode* t = s.top();
            s.pop();
            if(t->left == NULL && t->right == NULL)
                return t->val;
            else {
                if(t->right != NULL)
                    s.push(t->right);

                s.push(t);

                if(t->left != NULL)
                    s.push(t->left);   
                
                t->left = NULL;
                t->right = NULL;
            }
        }
        return -1;
    }
    
    bool hasNext() {
        return s.size() != 0;
    }
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */
