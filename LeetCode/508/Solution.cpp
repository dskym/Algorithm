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
    map<int, int> m;
    
    int solve(TreeNode* root) {
        if(root == NULL)
            return 0;
        
        int left = solve(root->left);
        int right = solve(root->right);
        
        int val = left + right + root->val;
        
        map<int ,int>::iterator iter;
        
        iter = m.find(val);
        
        if(iter == m.end())
            m[val] = 1;
        else
            m[val] += 1;
        
        return val;
    }
    
    vector<int> findFrequentTreeSum(TreeNode* root) {
        vector<int> result;
        
        solve(root);
        
        map<int ,int>::iterator iter;
        
        int target = 0;
        
        for(iter = m.begin();iter != m.end();++iter)
            target = max(target, iter->second);
        
        for(iter = m.begin();iter != m.end();++iter)
            if(iter->second == target)
                result.push_back(iter->first);
        
        return result;
    }
};
