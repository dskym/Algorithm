class Solution:
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        
        l = [[] for i in range(len(people))]
        
        people.sort(key=lambda p : p[1])
        people.sort(key=lambda p : p[0])
        
        for p in people :            
            count = 0
            index = 0
            
            while True :
                if count == p[1] and l[index] == []:
                    l[index] = p
                    break
                    
                if l[index] == [] or l[index][0] >= p[0]:
                    count += 1
                    
                index += 1
            
            
        return l
