class Solution:
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        temp = {}
        
        for num in nums: 
            if num in temp :
                temp[num] += 1
            else :
                temp[num] = 0
                
        data = sorted(temp.items(), key=lambda kv : kv[1], reverse=True)
                
        result = []
        
        for i in range(k) :
            result.append(data[i][0])
            
        return result
