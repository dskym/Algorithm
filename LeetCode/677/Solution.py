class MapSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.data = {}

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        self.data[key] = val

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        index = 0
        result = 0
        
        for key in self.data.keys() :
            if len(key) < len(prefix) :
                continue
            else :
                flag = True
                for i in range(len(prefix)) :
                    if key[i] != prefix[i] :
                           flag = False
                if flag :
                    result += self.data[key]
        return result

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
