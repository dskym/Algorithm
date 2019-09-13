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
    vector<vector<int>> levelOrder(TreeNode* root) {        
        if(root == NULL)
            return {};
        
        vector<vector<int>> ret;
        queue<pair<TreeNode*, int>> q;
        
        q.push({root, 0});
        
        while(!q.empty()) {
            auto temp = q.front();
            q.pop();
            
            TreeNode* node = temp.first;
            int height = temp.second;
            
            if(ret.size() == height) {
                vector<int> t;
                ret.push_back(t);
            }
            
            ret[height].push_back(node->val);
            
            if(node->left != NULL)
                q.push({node->left, height+1});
            
            if(node->right != NULL)
                q.push({node->right, height+1});
        }
        
        return ret;
    }
};
