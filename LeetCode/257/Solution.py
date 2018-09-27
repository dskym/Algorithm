# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def solve(self, root, path) :
        if root == None :
            return
        
        if root.left != None :        
            self.solve(root.left, path + str(root.val) + "->")
            
        if root.right != None :        
            self.solve(root.right, path + str(root.val) + "->")
        
        if root.left == None and root.right == None :
            path += str(root.val)
            self.result.append(path)
        
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        self.result = []
        
        self.solve(root, "")
        
        return self.result
