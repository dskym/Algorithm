class Solution:
    def findTheDifference(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        sLetter = [0 for i in range(26)]
        tLetter = [0 for i in range(26)]
        
        for c in s:
            sLetter[ord(c)-97] += 1
            
        for c in t:
            tLetter[ord(c)-97] += 1
            
        for i in range(26):
            if sLetter[i] + 1 == tLetter[i]:
                return chr(i + 97)
