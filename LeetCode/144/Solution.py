# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None    
class Solution:
    def preOrder(self, root):
        if root == None :
            return
        
        self.result.append(root.val)
        self.preOrder(root.left)
        self.preOrder(root.right)
        
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        self.result = []
        
        self.preOrder(root)
        
        return self.result
        
