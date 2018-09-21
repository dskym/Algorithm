class Solution:
    def frequencySort(self, s):
        """
        :type s: str
        :rtype: str
        """
        temp = {}
        
        for c in s :
            if c in temp :
                temp[c] += 1
            else :
                temp[c] = 1

        result = sorted(temp.items(), key=lambda v: v[1], reverse=True)

        str = ""
        
        for k, v in result :
            str += k * v
        
        return str
