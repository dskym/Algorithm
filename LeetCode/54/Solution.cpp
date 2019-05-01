class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> v;
        
        int index = 0;
        int m = matrix.size();
        
        if(m == 0)
            return v;
        
        int n = matrix[0].size();
        
        int topSpan = 0;
        int leftSpan = 0;
        int rightSpan = 0;
        int bottomSpan = 0;
        
        while(index < m * n) {
            for(int i=leftSpan;i<n-rightSpan;++i) {
                v.push_back(matrix[topSpan][i]);
                index++;
            }
             
            if(index >= m * n)
                break;
           
            topSpan++;
            
            for(int i=topSpan;i<m-bottomSpan;++i) {
                v.push_back(matrix[i][n-rightSpan-1]);
                index++;
            }
            
            if(index >= m * n)
                break;

            rightSpan++;

            for(int i=n-rightSpan-1;i>=leftSpan;--i) {
                v.push_back(matrix[m-bottomSpan-1][i]);
                index++;
            }
            
            if(index >= m * n)
                break;
            
            bottomSpan++;

            for(int i=m-bottomSpan-1;i>=topSpan;--i) {
                v.push_back(matrix[i][leftSpan]);
                index++;
            }
            
            if(index >= m * n)
                break;
            
            leftSpan++;
        }
        
        return v;
    }
};

