class Solution:
    def dailyTemperatures(self, temperatures):
        """
        :type temperatures: List[int]
        :rtype: List[int]
        """
        n = len(temperatures)
        result = [0 for i in range(n)]
        stack = []
        
        for i in range(n) :
            if len(stack) == 0 :
                stack.append(i)
            else :
                while temperatures[stack[-1]] < temperatures[i] :
                    result[stack[-1]] = i - stack[-1]
                    stack.pop()
                    
                    if len(stack) == 0 :
                        break
                        
                stack.append(i)
                
        return result
