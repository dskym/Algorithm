class Solution:
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        
        result = ""
        
        while num != 0 :   
            num = int(num)
            
            if int(num / 1000) :                
                result += 'M' * int(num / 1000)
                num -= 1000 * int(num / 1000)
            elif int(num / 900) : 
                result += 'CM'
                num -= 900
            elif int(num / 500) : 
                result += 'D' * int(num / 500)
                num -= 500 * int(num / 500)
            elif int(num / 400) : 
                result += 'CD'
                num -= 400
            elif int(num / 100) : 
                result += 'C' * int(num / 100)
                num -= 100 * int(num / 100)
            elif int(num / 90) : 
                result += 'XC'
                num -= 90
            elif int(num / 50) : 
                result += 'L' * int(num / 50)
                num -= 50 * int(num / 50)
            elif int(num / 40) : 
                result += 'XL'
                num -= 40
            elif int(num / 10) : 
                result += 'X' * int(num / 10)
                num -= 10 * int(num / 10)
            elif int(num / 9) : 
                result += 'IX'
                num -= 9
            elif int(num / 5) : 
                result += 'V' * int(num / 5)
                num -= 5 * int(num / 5)
            elif int(num / 4) : 
                result += 'IV'
                num -= 4
            else :
                result += 'I' * int(num)
                num = 0

        return result
