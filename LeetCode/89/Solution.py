class Solution:
    def grayCode(self, n):
        """
        :type n: int
        :rtype: List[int]
        """
        result = ["0", "1"]
        
        for i in range(n-1):
            tempLeft = []
            
            for j in range(len(result)):
                tempLeft.append("0" + result[j])
            
            tempRight = []
            
            for j in range(len(result)):
                tempRight.append("1" + result[len(result) - j - 1])
                
            result = tempLeft + tempRight
            
        answer = []
        
        if n == 0:
            answer.append(0)
        else:
            for i in result:
                answer.append(int(i, 2))
            
        return answer

