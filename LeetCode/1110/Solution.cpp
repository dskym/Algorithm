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
    vector<TreeNode*> result;
    
    void dfs(TreeNode* root, int find) {
        if(root->left != NULL) {
            if(root->left->val == find) {
                if(root->left->left != NULL)
                    result.push_back(root->left->left);
                if(root->left->right != NULL)
                    result.push_back(root->left->right);
                root->left = NULL;
            } else 
                dfs(root->left, find);
        }

        if(root->right != NULL) {
            if(root->right->val == find) {
                if(root->right->left != NULL)
                    result.push_back(root->right->left);
                if(root->right->right != NULL)
                    result.push_back(root->right->right);
                root->right = NULL;
            } else 
                dfs(root->right, find);
        }
    }
    
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {
        result.push_back(root);
        
        for(int i=0;i<to_delete.size();++i) {
            int value = to_delete[i];
                        
            for(int j=0;j<result.size();++j) {
                if(result[j]->val == value) {
                    if(result[j]->left != NULL)
                        result.push_back(result[j]->left);
                    
                    if(result[j]->right != NULL)
                        result.push_back(result[j]->right);
                    
                    result.erase(result.begin() + j);
                } else
                    dfs(result[j], value);
            }
        }
        
        return result;
    }
}
