class Solution:    
    def solve(self, index, arr, nums) :
        self.result.append(arr.copy())
        
        for i in range(index + 1, len(nums)) :
            arr.append(nums[i])
            self.solve(i, arr, nums)
            arr.remove(nums[i])
        
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        
        self.result = []
        self.result.append([])
        
        temp = []
        
        for i in range(len(nums)) :
            temp.append(nums[i])
            self.solve(i, temp, nums)
            temp.remove(nums[i])
            
        return self.result
