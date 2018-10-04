class Solution:
    def numRabbits(self, answers):
        """
        :type answers: List[int]
        :rtype: int
        """
        temp = {}
        
        result = 0
        
        for answer in answers :
            if answer == 0 :
                result += 1
                continue
            
            if answer in temp :
                count, flag = temp[answer]
                
                temp[answer] = (count, flag + 1)

                if flag == answer:
                    temp[answer] = (count + 1, 0)
            else :
                temp[answer] = (0, 1)
                            
        for answer in temp.keys() :
            count ,flag = temp[answer]
            result += (answer + 1) * count
            
            if flag != 0 :
                result += (answer + 1)

        return result
