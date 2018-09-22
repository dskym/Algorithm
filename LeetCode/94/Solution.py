# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def solve(self, root, result):        
        if root.left != None :
            self.solve(root.left, result)
        
        result.append(root.val)

        if root.right != None :
            self.solve(root.right, result)
            
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []
        
        if root != None :
            self.solve(root, result)
        
        return result
