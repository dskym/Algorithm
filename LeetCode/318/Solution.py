class Solution:
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        result = 0
        
        bitmask = []
        
        for word in words:
            temp = 0
            
            for c in word:
                temp |= 2 ** (ord(c) - 97)
            
            bitmask.append(temp)

        length = len(words)
        
        for i in range(length):
            for j in range(i + 1, length):
                if bitmask[i] & bitmask[j] == 0:
                    result = max(result, len(words[i]) * len(words[j]))
                    
        return result
