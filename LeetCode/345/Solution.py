class Solution:
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        stack = []
        result = ""
        
        for c in s:
            if c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u' or c == 'A' or c == 'E' or c == 'I' or c == 'O' or c == 'U' :
                stack.append(c)

        for c in s:
            if c == 'a' or c == 'e' or c == 'i' or c == 'o' or c == 'u' or c == 'A' or c == 'E' or c == 'I' or c == 'O' or c == 'U' :
                result += stack.pop()
            else:
                result += c
                
        return result
