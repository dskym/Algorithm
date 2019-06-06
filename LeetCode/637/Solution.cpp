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
    long long int count[10001];
    long long int value[10001];
    int n = 0;
    
    void dfs(TreeNode* root, int depth) {
        if(root == NULL)
            return;

        count[depth]++;
        value[depth] += root->val;
        
        dfs(root->left, depth+1);
        dfs(root->right, depth+1);
        
        n = max(n, depth);
    }
    
    vector<double> averageOfLevels(TreeNode* root) {
        for(int i=0;i<10001;++i) {
            count[i] = 0;
            value[i] = 0;
        }
        
        dfs(root, 0);
        
        vector<double> result;
        
        for(int i=0;i<=n;++i)
            result.push_back(value[i] / (double)count[i]);
        
        return result;
    }
};
