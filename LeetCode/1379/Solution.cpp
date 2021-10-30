/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution
{
public:
  TreeNode *traverse(TreeNode *root, TreeNode *target)
  {
    if (root->val == target->val)
    {
      return root;
    }

    if (root->left != NULL)
    {
      TreeNode *left = traverse(root->left, target);
      if (left != NULL)
        return left;
    }

    if (root->right != NULL)
    {
      TreeNode *right = traverse(root->right, target);
      if (right != NULL)
        return right;
    }

    return NULL;
  }

  TreeNode *getTargetCopy(TreeNode *original, TreeNode *cloned, TreeNode *target)
  {
    TreeNode *targetNode = traverse(original, target);

    return traverse(cloned, targetNode);
  }
};