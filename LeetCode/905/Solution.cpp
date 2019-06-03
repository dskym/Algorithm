class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        int n = A.size();
        
        vector<int> result(n, 0);
        
        int even = 0;
        
        for(int temp : A)
            if(temp % 2 == 0)
                even++;
        
        int index = 0;
        
        for(int temp : A) {
            if(temp % 2)
                result[even++] = temp;
            else
                result[index++] = temp;
        }
        
        return result;
    }
};
