class MagicDictionary:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.words = []

    def buildDict(self, dict):
        """
        Build a dictionary through a list of words
        :type dict: List[str]
        :rtype: void
        """
        for word in dict:
            self.words.append(word)

    def search(self, word):
        """
        Returns if there is any word in the trie that equals to the given word after modifying exactly one character
        :type word: str
        :rtype: bool
        """
        result = False
        
        for dictWord in self.words:            
            if len(dictWord) != len(word):
                continue
            
            self.check = {}

            length = len(word)
            
            for i in range(length):
                flag = True
                
                if dictWord[i] != word[i]:
                    if len(self.check) == 0:
                        self.check[dictWord[i]] = word[i]
                    else:
                        if dictWord[i] in self.check and \
                            self.check[dictWord[i]] == word[i]:
                            continue
                        else:
                            flag = False
                            break

            if flag is True and len(self.check) == 1:
                result = True
                break
                            
        return result

# Your MagicDictionary object will be instantiated and called as such:
# obj = MagicDictionary()
# obj.buildDict(dict)
# param_2 = obj.search(word)
