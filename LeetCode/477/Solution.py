class Solution:
    def totalHammingDistance(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result = 0
        
        for i in range(32):
            count = 0
            
            for num in nums:
                count += num >> i & 1
            
            result += count * (len(nums) - count)
        
        return result
