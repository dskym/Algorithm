# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def solve(self, root) :
        if root == None :
            return
                
        self.solve(root.left)
        
        self.temp -= 1
        
        if self.temp == 0 :
            self.result = root.val
        
        self.solve(root.right)
        
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        self.temp = k
        self.solve(root)
        
        return self.result
