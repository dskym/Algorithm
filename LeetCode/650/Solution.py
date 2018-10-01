class Solution:
    def solve(self, n) :
        if self.prime[n] :
            return n
        
        result = 10000
        
        for i in range(2, n) :
            if n % i == 0 :
                result = min(self.solve(i) + 1 + int((n - i) / i), result)
        
        return result

    def minSteps(self, n):
        """
        :type n: int
        :rtype: int
        """
        self.prime = [True for i in range(1001)]
        
        self.prime[0] = False
        self.prime[1] = False
        
        for i in range(2, 1001) :
            if self.prime[i] :
                for j in range(i+i, 1001, i) :
                    self.prime[j] = False
        
        if n == 1 :
            return 0
        else :
            return self.solve(n)
