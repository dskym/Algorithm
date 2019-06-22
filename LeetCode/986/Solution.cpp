class Solution {
public:
    vector<int> isIntersect(vector<int> a, vector<int> b) {
        if(a[0] <= b[0] && b[0] <= a[1] && a[0] <= b[1] && b[1] <= a[1])
            return b;
        else if(b[0] <= a[0] && a[0] <= b[1] && b[0] <= a[1] && a[1] <= b[1])
            return a;
        else if(a[0] <= b[0] && b[0] <= a[1] && a[1] <= b[1])
            return {b[0], a[1]};
        else if(b[0] <= a[0] && a[0] <= b[1] && b[1] <= a[1])
            return {a[0], b[1]};
        else
            return {};
    }
    
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        int lenA = A.size();
        int lenB = B.size();
        
        vector<vector<int>> result;
        
        int indexA = 0;
        int indexB = 0;
        
        while(indexA < lenA && indexB < lenB) {
            vector<int> temp = isIntersect(A[indexA], B[indexB]);
                
            if(temp.size() != 0)
                result.push_back(temp);
            
            if(A[indexA][1] < B[indexB][1])
                indexA++;
            else
                indexB++;
        }
                
        return result;
    }
};
