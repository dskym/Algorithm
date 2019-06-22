class Solution:
    def toGoatLatin(self, S: str) -> str:
        temp = "ma"
        
        l = S.split(' ')
        
        for i in range(len(l)) :
            temp += "a"
            
            if l[i][0] == 'a' or l[i][0] == 'A' or \
               l[i][0] == 'e' or l[i][0] == 'E' or \
               l[i][0] == 'i' or l[i][0] == 'I' or \
               l[i][0] == 'o' or l[i][0] == 'O' or \
               l[i][0] == 'u' or l[i][0] == 'U' :
                pass
            else :
                l[i] = l[i][1:] + l[i][0]
            
            l[i] += temp
            
        
        return " ".join(l)
