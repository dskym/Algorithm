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
    int total[10001];
    
    void dfs(TreeNode* root, int height) {
        if(root == NULL)
            return;
        
        total[height] += root->val;
        
        dfs(root->left, height+1);
        dfs(root->right, height+1);
    }
    
    int maxLevelSum(TreeNode* root) {
        for(int i=0;i<10001;++i)
            total[i] = 0;

        dfs(root, 0);
        
        int ret = total[0];
        int height = 0;
        
        for(int i=1;i<10001;++i) {            
            if(total[i] > ret) {
                ret = total[i];
                height = i + 1;
            }
        }

        return height;
    }
};
