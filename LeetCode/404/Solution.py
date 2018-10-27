# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def solve(self, root, leftCheck):        
        if root.left == None and root.right == None and leftCheck is True:
            return root.val
        elif root.left == None and root.right == None and leftCheck is False:
            return 0
    
        result = 0
        
        if root.left != None:
            result += self.solve(root.left, True)
        
        if root.right != None:
            result += self.solve(root.right, False)

        return result
    
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root == None:
            return 0
        else:
            return self.solve(root, False)
