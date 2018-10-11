class Solution(object):
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        lenNum1 = len(num1)
        lenNum2 = len(num2)
        
        c = 0
        
        zeroCount = max(lenNum1, lenNum2) - min(lenNum1, lenNum2)

        result = ""
        
        if lenNum1 > lenNum2:
            num2 = "0" * zeroCount + num2
        else:
            num1 = "0" * zeroCount + num1
                
        for i in range(max(lenNum1, lenNum2)-1, -1, -1):
            temp = int(num1[i]) + int(num2[i]) + c
            result = str(temp % 10) + result
            c = temp / 10
        
        if c == 1:
            result = "1" + result
            
        return result
