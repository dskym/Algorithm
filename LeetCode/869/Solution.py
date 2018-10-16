class Solution:
    def reorderedPowerOf2(self, N):
        """
        :type N: int
        :rtype: bool
        """
        digit = []
        checking = []
        
        num = 1
        
        while num <= 1000000000:
            checking.append(num)
            num *= 2

        for value in checking:
            if set(str(N)) == set(str(value)) and len(str(N)) == len(str(value)):
                return True
        
        return False
