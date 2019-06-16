class Solution:
    def findOcurrences(self, text: str, first: str, second: str) -> List[str]:
        str_list = text.split(' ')
        
        result = []
        
        for i in range(len(str_list) - 2):
            if str_list[i] == first and str_list[i+1] == second:
                result.append(str_list[i+2])
        
        return result
