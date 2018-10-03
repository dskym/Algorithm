class Solution:
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        result = []
        temp = 1
        
        for num in nums :
            temp *= num
            result.append(temp)
        
        temp = 1
        
        for i in range(len(nums) - 2, -2, -1) :
            if i == -1 :
                result[i + 1] = temp
            else :
                result[i + 1] = result[i] * temp
            temp *= nums[i + 1]
        
        return result
