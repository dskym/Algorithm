class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        result = {}
        
        for cpdomain in cpdomains:
            cnt, domain = cpdomain.split(' ')
            
            cnt = int(cnt)
            l = domain.split('.')
            
            for j in range(len(l)-1, -1, -1):
                key = ".".join(l[j:])
                
                if key not in result:
                    result[key] = cnt
                else:
                    result[key] += cnt

        result_list = []
        
        for key in result.keys():
            result_list.append(str(result[key]) + " " + key)
        
        return result_list
