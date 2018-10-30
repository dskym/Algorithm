class Solution:
    def eachSum(self, n):
        result = 0
        
        while n != 0:
            result += (n % 10) ** 2
            n = int(n / 10)
        
        return result
    
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        
        temp = n
        l = []
        
        while True:            
            if temp in l:
                return False
            elif temp == 1:
                return True
            
            l.append(temp)

            temp = self.eachSum(temp)
        
        
