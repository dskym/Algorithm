# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def solve(self, root, depth) :
        if len(self.result) == depth :
            self.result.append([])
            
        if root.left != None :
            self.solve(root.left, depth + 1)
            
        self.result[depth].append(root.val)
            
        if root.right != None :
            self.solve(root.right, depth + 1)

    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.result = []
        self.solve(root, 0)
        
        return self.result[len(self.result) - 1][0]
