class Solution:
    def maxHeight(self, root) :
        if root == None :
            return 0
        return max(self.maxHeight(root.left) + 1, self.maxHeight(root.right) + 1)
    
    def solve(self, root, start, end, depth) :
        if root == None or self.height <= depth:
            return
            
        mid = int((start + end) / 2)
        self.result[depth][mid] = str(root.val)
            
        self.solve(root.left, start, mid - 1, depth + 1)
        self.solve(root.right, mid + 1, end, depth + 1)
        
    def printTree(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[str]]
        """
        self.height = self.maxHeight(root)
        
        self.result = [["" for i in range(2 ** self.height - 1)] for j in range(self.height)]

        self.solve(root, 0, 2 ** self.height - 1, 0)
        
        return self.result

