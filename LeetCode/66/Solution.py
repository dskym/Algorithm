class Solution:
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        
        c = 0
                
        for i in range(length-1, -1, -1):
            if i == length-1:
                digits[i] = digits[i] + c + 1
            else:
                digits[i] = digits[i] + c
            
            if digits[i] == 10:
                digits[i] = 0
                
                if i == 0:
                    digits.insert(0, 1)
                else:
                    c = 1
            else:
                c = 0
            
        return digits
