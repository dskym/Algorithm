class Solution:
    def replaceWords(self, dict, sentence):
        """
        :type dict: List[str]
        :type sentence: str
        :rtype: str
        """
        words = sentence.split(' ')
        
        result = []
        
        for word in words:
            temp = word
            l = len(word)
            
            for root in dict:
                flag = True
                
                for index in range(min(len(word), len(root))):
                    if word[index] != root[index]:
                        flag = False
                        break
                
                if flag is True and l > len(root):
                    temp = root
                    l = len(root)
                    
            result.append(temp)
        
        return " ".join(result)
