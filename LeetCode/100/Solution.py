# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    """
    :type p: TreeNode
    :type q: TreeNode
    :rtype: bool
    """
    def solve(self, p, q):
        if p == None and q == None :
            return True
        
        if (p != None and q == None) or (p == None and q != None) or p.val != q.val :
            return False
        else :
            return self.solve(p.left, q.left) and self.solve(p.right, q.right)
        
    def isSameTree(self, p, q):
        return self.solve(p, q)
