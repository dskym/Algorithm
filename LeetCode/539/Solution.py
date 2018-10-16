class Solution:
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        timestamp = []
        
        for timePoint in timePoints:
            hh, mm = map(int, timePoint.split(':'))
            
            timestamp.append(hh * 60 + mm)
        
        timestamp.sort()
        
        result = timestamp[1] - timestamp[0]
        
        for i in range(1, len(timestamp) - 1):
            result = min(result, timestamp[i + 1] - timestamp[i])
            
        result = min(result, 60 * 24 + timestamp[0] - timestamp[len(timestamp) - 1])
        
        return result
